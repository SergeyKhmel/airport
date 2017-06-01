import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Serg_Smile on 30.05.2017.
 */
public class DBConnector {
    Properties properties;
    private final String DB_CONFIG_PATH = "src\\main\\resources\\db_config.properties";

    void createConnection() {
        properties = new Properties();
        try (FileInputStream fileStream = new FileInputStream(DB_CONFIG_PATH)) {
            properties.load(fileStream);
            String host = properties.getProperty("host_name");
            String login = properties.getProperty("user_name");
            String password = properties.getProperty("user_password");
            System.out.println("Host = "+host+"\nLogin = "+login+"\nPassword = "+password);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!!!");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
