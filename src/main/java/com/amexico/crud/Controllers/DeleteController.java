
package com.amexico.crud.Controllers;

import com.amexico.crud.models.Conectar;
import javax.servlet.http.HttpServletRequest;
import static javax.swing.JOptionPane.showMessageDialog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("delete.htm")
public class DeleteController {
    @RequestMapping(value = "delete.htm", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) 
    {
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(
                    "delete from usuarios "
                + "where "
                + "id=? ",
        id);
            showMessageDialog(null, "Borrado");
            IndexController redirect = new IndexController();
            return redirect.home();
    }
    
     private JdbcTemplate jdbcTemplate;
    public DeleteController()
    {
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
}
