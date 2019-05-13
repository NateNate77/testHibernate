package testHibernate.controller;

import testHibernate.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import testHibernate.jdbc.JDBCExample;
//import service.PersonService;

@Controller
@RequestMapping("/hello")
public class HelloSpringMVC {

//    @Autowired
//    private PersonService personService;

//    @Autowired
//    JDBCExample jdbcExample;



    @Autowired
    private PersonDAO personDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model model) {

//        model.addAttribute("greeting", "Hello Spring MVC");
//        model.addAttribute("persons", personService.getAllUsers() );
        try {
            model.addAttribute("persons", personDAO.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "helloworld";
    }
}
