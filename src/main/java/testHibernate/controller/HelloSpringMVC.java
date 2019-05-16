package testHibernate.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import testHibernate.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

=======
import testHibernate.jdbc.JDBCExample;
import testHibernate.model.Person;

import java.util.List;
//import service.PersonService;
>>>>>>> 0cf70acff711824ca7ef551564833f522108ff7a

@Controller
@RequestMapping("/hello")
public class HelloSpringMVC {

//    @Autowired
//    DataSource dataSource;
//
//    private JdbcTemplate jdbcTemplate;
//    String data;

//    @Autowired
//    JdbcTemplate jdbcTemplate;




    @PostConstruct
    public void init() throws IOException {

//        ClassLoader classLoader = getClass().getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("schema.sql");
//        data = readFromInputStream(inputStream);
//        jdbcTemplate = new JdbcTemplate(dataSource);
//        this.jdbcTemplate.execute(data);


//        Так тоже не работает!!!
//        this.jdbcTemplate.execute("create table person(   id integer not null,\n" +
//                "   name varchar(255) not null,\n" +
//                "   primary key(id))");

    }

//    private String readFromInputStream(InputStream inputStream) throws IOException {
//        StringBuilder resultStringBuilder = new StringBuilder();
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//            while ((line = br.readLine()) != null) {
//                resultStringBuilder.append(line).append("\n");
//
//            }
//        }
//        catch (Exception e){
//
//        }
//        return resultStringBuilder.toString();
//    }


    @Autowired
    private PersonDAO personDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model model) {

<<<<<<< HEAD
=======
        model.addAttribute("greeting", "Hello Spring MVC");
//        model.addAttribute("persons", personService.getAllUsers() );
>>>>>>> 0cf70acff711824ca7ef551564833f522108ff7a
        try {
            List<Person> list = personDAO.getAllPersons();
            model.addAttribute("persons", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "helloworld";
    }
}
