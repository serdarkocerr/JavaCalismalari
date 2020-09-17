package tr.com.siparis.database.manager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

import org.postgresql.util.DriverInfo;
import org.postgresql.*;

public class JdbcConnection {


    private static Optional<Connection> connection = Optional.empty();

    public static Optional<Connection> getConnection() {
        if (!connection.isPresent()) {
            String url = "jdbc:postgresql://localhost:5432/dbSiparis";
            String user = "postgres";
            String password = "kocer41388";

            try {
                Class.forName("org.postgresql.Driver"); 
                connection = Optional.ofNullable(
                    DriverManager.getConnection(url, user, password));
                String sf = DriverInfo.DRIVER_FULL_NAME;
//                org.postgresql.Driver driver = new Driver();
//
//                
//                System.out.println("JdbcConnection.getConnection() Driver.getVersion(); " + driver.getMajorVersion());
//                System.out.println("JdbcConnection.getConnection() DRIVER FULL NAME : " + sf );
            } catch ( ClassNotFoundException ex) {
            	ex.printStackTrace();
            } catch (Exception e) {
            	e.printStackTrace();			}
        }

        return connection;
    }
}
