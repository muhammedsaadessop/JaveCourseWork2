
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {
    
   public static void main(String[] args) {
        List<String> lines = read("literacy.csv");
        lines.sort((line1, line2) -> {
            double rate1 = Double.parseDouble(line1.split(",")[5]);
            double rate2 = Double.parseDouble(line2.split(",")[5]);
            return Double.compare(rate1, rate2);
        });

        for (String line : lines) {
            String[] parts = line.split(",");
            String country = parts[3];
            String year = parts[4];
            String gender = parts[2].replace("(%)", "").replace("(", "").trim(); 
            String literacyRate = parts[5].trim();
            
            System.out.println(String.format("%s (%s), %s, %s", country, year, gender, literacyRate));
        }
    }

    public static List<String> read(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return lines;
    }
}
