package chu.jdbc;

import java.util.List;
import java.util.Optional;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author chuchip
 */
@Controller
@RequestMapping("/")
public class Principal {   
 
    @Autowired
    ServletContext servletContext;

    @Autowired
    JdbcEjemplo repositorio;

    @Autowired
    UsuarioRepositorio usuRep;

    @RequestMapping(value = "/jdbc", method = RequestMethod.GET)
    public String getJdbc(Model modelo) {
        servletContext.log("En JDBC jsp");
        Usuario us = repositorio.findByUsername("cpuente");
        modelo.addAttribute("usuario", us.getNombre());
        servletContext.log("Nombre usuario: " + us.getNombre());
        return "jdbc";

    }
    @RequestMapping(value = "/todosusuarios", method = RequestMethod.GET)
    public String getJdbcTodosUsuarios(Model modelo) 
    {
        servletContext.log("En getJdbcTodosUsuarios ");
        List<Usuario> listaUsuarios = repositorio.findAllUsernames();
        modelo.addAttribute("listadeUsuarios",listaUsuarios);        
        servletContext.log("Numero de  usuarios: " + listaUsuarios.size());                   
        return "jdbcTodosUsuarios";
    }
    
    @RequestMapping(value = "/todosPorNombre")
    public String getJPAUsuariosPorNombre(Model modelo,@RequestParam("nombre") String nombre) 
    {
        servletContext.log("En getJPAUsuariosPorNombre. Nombre pasado: "+nombre);
       // List<Usuario>  listaNombres = usuRep.buscaPorNombre(nombre);
        List<Usuario>  listaNombres = usuRep.findIsLikeNombreOrderByNombre(nombre);
        modelo.addAttribute("listaNombres",listaNombres);
        modelo.addAttribute("nombreUsuario",nombre);
        servletContext.log("Numero de  Nombres: " + listaNombres.size());          
        return "jpaNombreUsuario";
    }
    
    @RequestMapping(value = "/jpa", method = RequestMethod.GET)
    public ModelAndView getJPA(HttpServletRequest request) {
        servletContext.log("En JPA jsp");
        Optional<Usuario> usu = usuRep.findById("cpuente");
        ModelAndView modelo = new ModelAndView("jpa");

        String usuario = (usu.isPresent() ? usu.get().getNombre() : "Usuario cpuente No encontrado");
        servletContext.log("Usuario: " + usuario);
        modelo.addObject("usuario", usuario);
        return modelo;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        servletContext.log("En index jsp");
        return "index";
    }

}
