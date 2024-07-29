
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream()
                      .filter(num -> num > 0)
                      .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-10, 15, -3, 22, 0, 5, -7);
        List<Integer> positiveNumbers = positive(numbers);
        System.out.println(positiveNumbers); 
    }

}
