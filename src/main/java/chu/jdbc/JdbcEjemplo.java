package chu.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chuchip
 */
@Repository
public class JdbcEjemplo {

    @Autowired
    private JdbcOperations jdbc;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    public Usuario findByUsername(String username) {        
        return jdbc.queryForObject(
                "select login,nombre from usuario where login=?",
                new usuarioRowMapper(), username);
    }
    
    public List<Usuario> findAllUsernames() {
         return  jdbc.query(
                "select login,nombre from usuario ",
                (rs, rowNum) -> new Usuario(rs.getString("login"),rs.getString("nombre"))
        );
        
//        return jdbc.queryForObject(
//                "select login,nombre from usuario ",
//                new usuarioListaRowMapper() );
    }
    private class usuarioRowMapper implements RowMapper<Usuario> {

        @Override
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Usuario(
                    rs.getString("login"),
                    rs.getString("nombre"));
        }
    }
    /*
   private  class usuarioListaRowMapper implements RowMapper<List<Usuario>> {

        @Override
        public List<Usuario> mapRow(ResultSet rs, int rowNum) throws SQLException {
            ArrayList<Usuario> listaUsuarios = new ArrayList();
            do
            {
                listaUsuarios.add(new Usuario(rs.getString("login"),
                                    rs.getString("nombre")));

            } while (rs.next());
            return listaUsuarios;
        }
    }
*/
}