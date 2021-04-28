
package dms.connection;

import dms.util.PropertyFileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author Javidan
 */
public class Connector {

    private static Connection connection;

    private Connector() {
    }

    public static Connection getConnection() {
        try {
            PropertyFileReader fileReader = new PropertyFileReader();
            Map<String, String> map = fileReader.getPropValues();
            Class.forName(map.get("driver"));
            connection = DriverManager.getConnection(map.get("url"), map.get("user"), map.get("password"));
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

}
