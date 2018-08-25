package chu.jdbc;

/**
 *
 * @author chuchip
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;


@Data
@Entity
@Table(name = "usuario",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"login"})})
public class Usuario implements Serializable {

    @Id
    String login;

    @Column
    String nombre;
    public Usuario() {}
    public Usuario(String login, String nombre) {
        
        this.login = login;
        this.nombre = nombre;
    }
}
