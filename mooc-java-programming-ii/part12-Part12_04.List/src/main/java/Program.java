
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        List list = new List();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("List size: " + list.size()); 
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("List contains 3: " + list.contains(3)); 

        list.remove(1);

        System.out.println("List size after removal: " + list.size()); 
        System.out.println("Element at index 1 after removal: " + list.get(1)); 
    }

}
