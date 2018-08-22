package chu.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Repositorio  {
  
  @Autowired
  private JdbcOperations jdbc;

   public Usuario findByUsername(String username) {
    return jdbc.queryForObject(
        "select login,nombre from usuario where login=?", 
        new usuarioRowMapper(), 
        username);
  }

 private static class usuarioRowMapper implements RowMapper<Usuario> {
     
    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Usuario(
          rs.getString("login"),
          rs.getString("nombre"));
    }
  }
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
  }
}

