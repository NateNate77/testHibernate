package testHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import testHibernate.dao.PersonDAO;


@Controller
@RequestMapping("/hello")
public class HelloSpringMVC {

    @Autowired
    private PersonDAO personDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model model) {

        try {
            model.addAttribute("persons", personDAO.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "helloworld";
    }
}
