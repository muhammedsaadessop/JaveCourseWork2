package FlightControl;

import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightControl flightControl = new FlightControl(scanner);

        while (true) {
            System.out.println("Airport Asset Control");
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            String command = scanner.nextLine();

            if (command.equals("1")) {
                flightControl.addAirplane();
            } else if (command.equals("2")) {
                flightControl.addFlight();
            } else if (command.equals("x")) {
                break;
            }
        }

        while (true) {
            System.out.println("Flight Control");
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            String command = scanner.nextLine();

            if (command.equals("1")) {
                flightControl.printAirplanes();
            } else if (command.equals("2")) {
                flightControl.printFlights();
            } else if (command.equals("3")) {
                flightControl.printAirplaneDetails();
            } else if (command.equals("x")) {
                break;
            }
        }
    }
}
