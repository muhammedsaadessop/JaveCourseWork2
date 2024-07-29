package dictionary;

import java.io.*;
import java.util.*;

public class SaveableDictionary {
    private Map<String, String> finnishToOther;
    private Map<String, String> otherToFinnish;
    private String fileName;

    public SaveableDictionary() {
        this.finnishToOther = new HashMap<>();
        this.otherToFinnish = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.fileName = file;
    }

    public void add(String word, String translation) {
        if (!finnishToOther.containsKey(word)) {
            finnishToOther.put(word, translation);
            otherToFinnish.put(translation, word);
        }
    }

    public String translate(String word) {
        if (finnishToOther.containsKey(word)) {
            return finnishToOther.get(word);
        } else if (otherToFinnish.containsKey(word)) {
            return otherToFinnish.get(word);
        }
        return null;
    }

    public void delete(String word) {
        if (finnishToOther.containsKey(word)) {
            String translation = finnishToOther.remove(word);
            otherToFinnish.remove(translation);
        } else if (otherToFinnish.containsKey(word)) {
            String translation = otherToFinnish.remove(word);
            finnishToOther.remove(translation);
        }
    }

    public boolean load() {
        if (fileName == null) {
            return false;
        }
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    add(parts[0], parts[1]);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean save() {
        if (fileName == null) {
            return false;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, String> entry : finnishToOther.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
