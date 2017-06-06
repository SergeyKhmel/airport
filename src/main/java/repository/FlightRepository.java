package repository;

import entities.Flight;

import java.sql.*;

import java.util.List;

/**
 * Created by sergiy on 06.06.17.
 */
public class FlightRepository implements RepositoryInterface{
    private Connection connection;

    public FlightRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T> void add(T entity) throws SQLException {
        Flight flightEntity = (Flight) entity;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into flight(flight_number, `from`, `to`)\n" +
                "VALUES(?, ?, ?);");
        preparedStatement.setString(1, flightEntity.getFlightNumber());
        preparedStatement.setString(2, flightEntity.getFrom());
        preparedStatement.setString(3, flightEntity.getTo());
        preparedStatement.execute();

       /* Statement statement =  connection.createStatement();
        String query;
        if (flightEntity.getID() == null) {
            query = "INSERT into flight(flight_number, `from`, `to`)\n" +
                    "VALUES(\"AK47\", \"Vinnitsa\", \"Napoli\");";
        }else {
            query = "INSERT into flight(id, flight_number, `from`, `to`)\n" +
                    "VALUES("+flightEntity.getID()+", \"AK47\", \"Vinnitsa\", \"Napoli\");";
        }
        statement.execute(query);*/
    }

    @Override
    public <T> void remuve(T entity) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM flight WHERE id = ?;");
        preparedStatement.setInt(1, (Integer) entity);

        preparedStatement.execute();
    }

    @Override
    public <T> void update(T entity) throws SQLException {
        Flight flightEntity = (Flight) entity;
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE flight SET flight_number = ?, `from` = ?, `to` = ? WHERE id = ?;");
        preparedStatement.setString(1, flightEntity.getFlightNumber());
        preparedStatement.setString(2, flightEntity.getFrom());
        preparedStatement.setString(3, flightEntity.getTo());
        preparedStatement.setInt(4, flightEntity.getID());
        preparedStatement.execute();
    }

    @Override
    public <T> List<T> getAll() {

        return null;
    }
}
