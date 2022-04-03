/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chu.jdbc;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author chuchip
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {
    
  
    @Query("select u from Usuario u where u.nombre like :nombre order by u.nombre")
    List<Usuario> buscaPorNombre(@Param("nombre") String nombre);
    
    /**
     * Esta funcion hace exactamente lo mismo que la funcion buscaPorNombre pero utilizando DSL (Domain Specificic Lenguage) de Spring
     * @param nombre Nombre de usuario a buscar (sin wildcards, ya lo pone JPL)
     * @return Lista de Usuarios a buscar
     */
    List<Usuario> findByNombreLikeOrderByNombre(String nombre);
}
