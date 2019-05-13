package testHibernate.dao;

import org.hibernate.Query;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Repository;
import testHibernate.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
//import sun.jdbc.odbc.ee.DataSource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


//@Repository
@Component
public class PersonDAO {

//    @Autowired
//    private DataSource dataSource;

//    @Autowired
//    private SessionFactory sessionFactory;

//    private static Connection getH2Connection() throws SQLException {
//        return DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/default");
//    }


    @PersistenceContext(unitName = "testHibernate.person_catalog")
    private EntityManager em;

      @Transactional
//    @Transactional(readOnly = true)
    public List<Person> getAllPersons() throws SQLException, Exception {

        em.createNativeQuery("create table if not exists person\n" +
                "(\n" +
                "   id integer not null,\n" +
                "   name varchar(255) not null,\n" +
                "   primary key(id)\n" +
                ");").executeUpdate();

        em.createNativeQuery("INSERT INTO person (id, name) VALUES (?,?)")
                .setParameter(1, 10001)
                .setParameter(2, "Renn").executeUpdate();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> q = cb.createQuery(Person.class);
        Root<Person> root = q.from(Person.class);
        q.select(root);
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        EmbeddedDatabase db = builder
//                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
//                .addScript("schema.sql")
//                .addScript("data.sql")
//                .build();
//        em.createNativeQuery("DROP SCHEMA" + quote("schema")).executeUpdate();

        return em.createQuery(q).getResultList();
    }

//    @Transactional(readOnly = true)
//    public Collection<Person> getAllProviders() throws SQLException, Exception {
//        return sessionFactory.getCurrentSession().createQuery("from person p").list();
//    }


//    public List<Person> getAllPersons() {
//        // SELECT * FROM PERSON
//
//        TypedQuery<Person> query = em.createQuery(
//                "from person", Person.class);
//        return query.getResultList();
//        List<Person> allPersons = new ArrayList<Person>();
//        return allPersons;

//        List<Person> result = new ArrayList<Person>();
//        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//            PreparedStatement statement = connection.prepareStatement("select * from person");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                Person person = new Person();
//                person.setId(rs.getInt(person.getId()));
//                person.setName(rs.getString(person.getName()));
//                result.add(person);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }


}
