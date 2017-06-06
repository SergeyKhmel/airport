package entities;

/**
 * Created by sergiy on 06.06.17.
 */
public class Flight { //POJO
    private Integer ID;
    private String FlightNumber, from, to;

    public Flight(Integer ID, String flightNumber, String from, String to) {
        this.ID = ID;
        FlightNumber = flightNumber;
        this.from = from;
        this.to = to;
    }

    public Flight(Integer ID) {
        this.ID = ID;
    }

    public Flight() {
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getID() {
        return ID;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
