
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");

        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("end")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or \"end\".");
            }
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String choice = scanner.next();

        if (choice.equals("n")) {
            double averageNegative = numbers.stream()
                    .filter(num -> num < 0)
                    .mapToDouble(num -> num)
                    .average()
                    .orElse(0.0);
            System.out.println("Average of the negative numbers: " + averageNegative);
        } else if (choice.equals("p")) {
            double averagePositive = numbers.stream()
                    .filter(num -> num > 0)
                    .mapToDouble(num -> num)
                    .average()
                    .orElse(0.0);
            System.out.println("Average of the positive numbers: " + averagePositive);
        } else {
            System.out.println("Invalid choice. Please enter 'n' or 'p'.");
        }

        scanner.close();
    }
}
