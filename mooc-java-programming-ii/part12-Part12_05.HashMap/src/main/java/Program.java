
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(map.get("one"));   
        System.out.println(map.get("two"));  
        System.out.println(map.get("three")); 

        map.remove("two");

        System.out.println(map.get("two"));   
    }

}
