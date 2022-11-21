package repo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.beans.JavaBean;
import java.sql.Connection;
import java.sql.SQLException;

@JavaBean
public class DataSource {
   // private static final String CONFIG_FILE = "src/main/resources/dataSource.properties";
    private static HikariConfig config; //Static is better or not?
    private static HikariDataSource ds; //Static is better or not?

    public static void init() {
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/epam_project_testing");
        config.setUsername("root");
        config.setPassword("root");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

      //  config = new HikariConfig(CONFIG_FILE);
        ds = new HikariDataSource(config);
    }

    private DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
