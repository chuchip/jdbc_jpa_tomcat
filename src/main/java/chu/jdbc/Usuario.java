package chu.jdbc;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author chuchip
 */
@Entity
@Table(name = "usuario",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"login"})})
public class Usuario implements Serializable {

    @Id
    String login;

    @Column
    String nombre;

    public Usuario() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String login, String nombre) {
        this.login = login;
        this.nombre = nombre;
    }
}
