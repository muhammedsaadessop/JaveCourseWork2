
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueLastNames {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> lastNames = new HashSet<>();

        while (true) {
            System.out.println("Continue personal information input? \"quit\" ends:");
            String command = scanner.nextLine();

            if (command.equals("quit")) {
                break;
            }

            System.out.print("Input first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Input last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Input the year of birth: ");
            String yearOfBirth = scanner.nextLine();

            lastNames.add(lastName);
        }

        System.out.println("Unique last names in alphabetical order:");
        lastNames.stream()
                 .sorted()
                 .forEach(System.out::println);

        scanner.close();
    }
}
