import java.util.Scanner;
import java.util.regex.Pattern;

public class Checker {
   public boolean isDayOfWeek(String string) {
        return Pattern.matches("mon|tue|wed|thu|fri|sat|sun", string);
    }

    public boolean allVowels(String string) {
        return Pattern.matches("[aeiou]+", string);
    }

    public boolean timeOfDay(String string) {
        return Pattern.matches("([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]", string);
    }

   
}
