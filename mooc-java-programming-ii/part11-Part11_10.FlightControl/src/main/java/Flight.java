package FlightControl;
public class Flight {
    private Airplane airplane;
    private String departureAirport;
    private String destinationAirport;

    public Flight(Airplane airplane, String departureAirport, String destinationAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    @Override
    public String toString() {
        return airplane + " (" + departureAirport + "-" + destinationAirport + ")";
    }
}
