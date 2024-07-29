
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
   public static List<Book> readBooks(String file) {
        List<Book> books = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            
            for (String line : lines) {
                String[] parts = line.split(",");
                
                if (parts.length == 4) {
                    String name = parts[0];
                    int publishingYear = Integer.parseInt(parts[1]);
                    int pageCount = Integer.parseInt(parts[2]);
                    String author = parts[3];
                    
                    Book book = new Book(name, publishingYear, pageCount, author);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return books;
    }

    public static void main(String[] args) {
        List<Book> books = readBooks("books.txt");
        books.forEach(System.out::println);
    }

}
