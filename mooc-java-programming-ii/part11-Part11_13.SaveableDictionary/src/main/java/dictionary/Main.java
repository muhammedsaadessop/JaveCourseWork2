package dictionary;

public class Main {
    public static void main(String[] args) {
        SaveableDictionary dictionary = new SaveableDictionary();
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("ohjelmointi", "programming");

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("monkey"));
        System.out.println(dictionary.translate("ohjelmointi"));
        System.out.println(dictionary.translate("banana"));

        dictionary.delete("apina");
        dictionary.delete("banana");

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("monkey"));
        System.out.println(dictionary.translate("banana"));
        System.out.println(dictionary.translate("banaani"));
        System.out.println(dictionary.translate("ohjelmointi"));

        SaveableDictionary fileDictionary = new SaveableDictionary("words.txt");
        boolean loadSuccess = fileDictionary.load();
        if (loadSuccess) {
            System.out.println("Successfully loaded the dictionary from file");
        } else {
            System.out.println("Failed to load the dictionary from file");
        }

        System.out.println(fileDictionary.translate("apina"));
        System.out.println(fileDictionary.translate("ohjelmointi"));
        System.out.println(fileDictionary.translate("alla oleva"));

        boolean saveSuccess = fileDictionary.save();
        if (saveSuccess) {
            System.out.println("Successfully saved the dictionary to file");
        } else {
            System.out.println("Failed to save the dictionary to file");
        }
    }
}
