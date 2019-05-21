package testHibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import testHibernate.dao.PersonDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Configuration
//@PropertySource("classpath:application.properties")
//@ComponentScan(basePackages="testHibernate")
public class MyApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);
    String data;
    DriverManagerDataSource dataSource;

    public MyApp() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() throws IOException {

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT TABLE_CATALOG, TABLE_SCHEMA, table_name FROM INFORMATION_SCHEMA.TABLES");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LOGGER.info(String.format("table name = %s.%s.%s", rs.getString("TABLE_CATALOG"), rs.getString("TABLE_SCHEMA"), rs.getString("table_name")));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

            data = "create table person( id integer not null," +
                    "                 name varchar(255) not null," +
                    "                 primary key(id));";

            try {
                Connection conn = dataSource.getConnection();
                conn.prepareStatement(data);
                System.out.println(data);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return dataSource;
    }

}
