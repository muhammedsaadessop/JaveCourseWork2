
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>(); 

        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number or 'end' to stop.");
            }
        }

        double average = numbers.stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .orElse(Double.NaN);

        System.out.println("average of the numbers: " + average);
    }

}
