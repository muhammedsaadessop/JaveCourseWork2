public class Main {
    public static void main(String[] args) {
        // Testing TripleTacoBox
        TacoBox tripleBox = new TripleTacoBox();
        System.out.println("TripleTacoBox initial tacos: " + tripleBox.tacosRemaining());
        tripleBox.eat();
        System.out.println("TripleTacoBox tacos after eating: " + tripleBox.tacosRemaining());

        // Testing CustomTacoBox
        TacoBox customBox = new CustomTacoBox(5);
        System.out.println("CustomTacoBox initial tacos: " + customBox.tacosRemaining());
        customBox.eat();
        customBox.eat();
        System.out.println("CustomTacoBox tacos after eating twice: " + customBox.tacosRemaining());
    }
}
