package testHibernate.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import testHibernate.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


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

        try {
            model.addAttribute("persons", personDAO.getAllPersons());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "helloworld";
    }
}
