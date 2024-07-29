package FlightControl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlightControl {
    private Map<String, Airplane> airplanes;
    private Map<String, Flight> flights;
    private Scanner scanner;

    public FlightControl(Scanner scanner) {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.scanner = scanner;
    }

    public void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());
        airplanes.put(id, new Airplane(id, capacity));
    }

    public void addFlight() {
        System.out.print("Give the airplane id: ");
        String airplaneId = scanner.nextLine();
        System.out.print("Give the departure airport id: ");
        String departure = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destination = scanner.nextLine();

        Airplane airplane = airplanes.get(airplaneId);
        if (airplane != null) {
            Flight flight = new Flight(airplane, departure, destination);
            flights.put(departure + "-" + destination + "-" + airplaneId, flight);
        } else {
            System.out.println("Airplane not found.");
        }
    }

    public void printAirplanes() {
        for (Airplane airplane : airplanes.values()) {
            System.out.println(airplane);
        }
    }

    public void printFlights() {
        for (Flight flight : flights.values()) {
            System.out.println(flight);
        }
    }

    public void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        Airplane airplane = airplanes.get(id);
        if (airplane != null) {
            System.out.println(airplane);
        } else {
            System.out.println("Airplane not found.");
        }
    }
}
