public class Program {

    public static void main(String[] args) {
        MagicSquareFactory msFactory = new MagicSquareFactory();
        MagicSquare magicSquare = msFactory.createMagicSquare(3);

        System.out.println("Magic Square:");
        System.out.println(magicSquare);

        System.out.println("Row sums:");
        for (int sum : magicSquare.sumsOfRows()) {
            System.out.println(sum);
        }

        System.out.println("Column sums:");
        for (int sum : magicSquare.sumsOfColumns()) {
            System.out.println(sum);
        }

        System.out.println("Diagonal sums:");
        for (int sum : magicSquare.sumsOfDiagonals()) {
            System.out.println(sum);
        }

        System.out.println("Is magic square: " + magicSquare.isMagicSquare());
    }
}
