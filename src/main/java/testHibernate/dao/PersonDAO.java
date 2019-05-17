package testHibernate.dao;

import org.hibernate.Query;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;
import testHibernate.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
//import sun.jdbc.odbc.ee.DataSource;
import javax.annotation.PostConstruct;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


//@Repository
@Component
public class PersonDAO {

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;
//    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() throws IOException {

//        Resource initSchema = new ClassPathResource("schema.sql");
//        Resource initData = new ClassPathResource("data.sql");
//        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        databasePopulator.addScript(initSchema);
//        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

//        ClassLoader classLoader = getClass().getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("schema.sql");
//        String data = readFromInputStream(inputStream);
//        jdbcTemplate = new JdbcTemplate(dataSource);
//        this.jdbcTemplate.execute(data);

//                jdbcTemplate.execute("create table person( id integer not null,\n" +
//                "   name varchar(255) not null,\n" +
//                "   primary key(id))");

//        LOGGER.info("Create table");

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


    @PersistenceContext(unitName = "testHibernate.person_catalog")
    private EntityManager em;

      @Transactional(value = "txManager")

    public List<Person> getAllPersons() throws SQLException, Exception {

//          ClassLoader classLoader = getClass().getClassLoader();
//          InputStream inputStream = classLoader.getResourceAsStream("schema.sql");
//          String data = readFromInputStream(inputStream);
//
//          em.createNativeQuery(data);

//        em.createNativeQuery("create table if not exists person\n" +
//                "(\n" +
//                "   id integer not null,\n" +
//                "   name varchar(255) not null,\n" +
//                "   primary key(id)\n" +
//                ");").executeUpdate();
//
//          em.createNativeQuery(data);

//          em.createNativeQuery("INSERT INTO person (id, name) VALUES (?,?)")
//                .setParameter(1, 10001)
//                .setParameter(2, "Renn").executeUpdate();
//        em.createNativeQuery("INSERT INTO person (id, name) VALUES (?,?)")
//                  .setParameter(1, 10002)
//                  .setParameter(2, "Ravi").executeUpdate();



        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> root = q.from(Person.class);
        q.select(root);

        return em.createQuery(q).getResultList();
    }

//        private String readFromInputStream(InputStream inputStream) throws IOException {
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

}
