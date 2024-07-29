
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter numbers (negative number to stop):");
        
        while (true) {
            int input = scanner.nextInt();
            if (input < 0) {
                break;
            }
            numbers.add(input);
        }

        System.out.println("Numbers between 1 and 5:");
        numbers.stream()
               .filter(num -> num >= 1 && num <= 5)
               .forEach(System.out::println);
        
        scanner.close();
    }
}
