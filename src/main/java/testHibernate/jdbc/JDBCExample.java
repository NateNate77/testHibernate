package testHibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import testHibernate.model.Person;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class JDBCExample {

//    @Autowired
//    DataSource dataSource;
//
//    private JdbcTemplate jdbcTemplate;
//    @PostConstruct
//    public void init() {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }

//    public List<Person> queryAllPersons() {
//
//        final String QUERY_SQL = "SELECT * FROM PERSON";
//        List<Person> personList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<Person>() {
//            public Person mapRow(ResultSet resulSet, int rowNum) throws SQLException {
//                Person person = new Person();
//                person.setId(resulSet.getInt("IDUSER"));
//                person.setName(resulSet.getString("USERNAME"));
//                return person;
//            }
//        });
//        return personList;
//    }
}
