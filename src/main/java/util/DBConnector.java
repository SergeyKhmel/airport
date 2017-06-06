package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Serg_Smile on 30.05.2017.
 */
public class DBConnector {
    private Connection connection;
    private static DBConnector INSTANSE;
    private final String DB_CONFIG_PATH = "src/main/resources/db_config.properties";
    private String DB_TYPE, DB_NAME, HOST, PORT, LOGIN, PASSWORD;

    public  Connection getConnection() throws SQLException {
        if (this.connection != null) return  this.connection;
        getAndSetProperties(DB_CONFIG_PATH);
        return this.connection = DriverManager.getConnection(DB_TYPE+HOST+":"+PORT+"/"+DB_NAME, LOGIN, PASSWORD);
    }

    private void getAndSetProperties(String configPath) {
        Properties properties = new Properties();
        try (FileInputStream fileStream = new FileInputStream(configPath)) {
            properties.load(fileStream);
            DB_NAME = properties.getProperty("db_name");
            DB_TYPE = properties.getProperty("db_type");
            HOST = properties.getProperty("host_name");
            PORT = properties.getProperty("port");
            LOGIN = properties.getProperty("user_name");
            PASSWORD = properties.getProperty("user_password");

            System.out.println(DB_TYPE+HOST+":"+PORT+"/"+DB_NAME+", Login: "+LOGIN+", Password: "+PASSWORD);



        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!!!");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private DBConnector(){
    }
    public  static  DBConnector getINSTANSE(){
        return  INSTANSE == null ? INSTANSE = new DBConnector() : INSTANSE;
    }
}
