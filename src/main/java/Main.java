import entities.Flight;
import repository.FlightRepository;
import util.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Serg_Smile on 30.05.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        DBConnector dbConnector = DBConnector.getINSTANSE();
        Connection connection = dbConnector.getConnection();
        System.out.println(connection == null ? "NO CONNECTION !" : "CONNECTION SUCCESFUL!");
        FlightRepository flightRepository = new FlightRepository(connection);
        //flightRepository.add(new Flight(34,"KV-7777_SF", "Kyev", "San Fransisco"));
        flightRepository.update(new Flight(34,"KV-1111-SF", "San Fransisco", "Kyev"));

    }
}
