
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("How many random numbers should be printed?");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            int number = random.nextInt(11); 
            System.out.println(number);
        }
        
        scanner.close();
    }
}
