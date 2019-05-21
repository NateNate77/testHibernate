package testHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//@Component
public class DBUtils {

//    @Autowired
//    DataSource dataSource;
//    String data;
//
//    @PostConstruct
//    public void init(){
//        data = "create table person( id integer not null," +
//                "                 name varchar(255) not null," +
//                "                 primary key(id));";
//
//        try {
//            Connection conn = dataSource.getConnection();
//            conn.prepareStatement(data);
//            System.out.println(data);
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
