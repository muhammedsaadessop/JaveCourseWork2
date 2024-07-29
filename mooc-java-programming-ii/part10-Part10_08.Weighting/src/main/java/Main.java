

public class Main {

    public static void main(String[] args) {
        Item item1 = new Item("Laptop", 2000);
        Item item2 = new Item("Books", 5000);
        Item item3 = new Item("Clothes", 3000);
        Item item4 = new Item("Phone", 200);
        
        Suitcase suitcase1 = new Suitcase(10000);
        Suitcase suitcase2 = new Suitcase(5000);
        
        suitcase1.addItem(item1);
        suitcase1.addItem(item2);
        suitcase1.addItem(item3);
        suitcase2.addItem(item4);
        
        Hold hold = new Hold(20000);
        
        hold.addSuitcase(suitcase1);
        hold.addSuitcase(suitcase2);
        
        System.out.println(hold);
        hold.printItems();
        
        System.out.println("Heaviest item in suitcase 1: " + suitcase1.heaviestItem());
        System.out.println("Heaviest item in suitcase 2: " + suitcase2.heaviestItem());
    }
}
