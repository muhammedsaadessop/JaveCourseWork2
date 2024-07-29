
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        
        System.out.println("Enter your inputs (press enter on an empty line to stop):");
        
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            inputs.add(input);
        }

        System.out.println("You entered:");
        for (String line : inputs) {
            System.out.println(line);
        }

        scanner.close();
    }
}
