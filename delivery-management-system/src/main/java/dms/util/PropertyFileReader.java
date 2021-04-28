
package dms.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Javidan
 */
public class PropertyFileReader {

    private static final String FILE = "config.properties"; 
    private InputStream inputStream;

    public Map<String, String> getPropValues() throws IOException {
        Map<String, String> propKeyVal = new HashMap<>();
        
        try {
            Properties prop = new Properties();
            String propFileName = FILE;

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException(FILE + " not found in the classpath");
            }
            
            propKeyVal.put("driver", prop.getProperty("mysql.driver"));
            propKeyVal.put("url", prop.getProperty("mysql.url"));
            propKeyVal.put("user", prop.getProperty("mysql.user"));
            propKeyVal.put("pass", prop.getProperty("mysql.password"));
            
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return propKeyVal;
    }
}
