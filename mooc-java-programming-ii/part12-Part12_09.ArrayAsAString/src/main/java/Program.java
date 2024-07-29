
public class Program {
    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < array.length; i++) {
            for (int num : array[i]) {
                sb.append(num);
            }
            if (i < array.length - 1) {
                sb.append(System.lineSeparator());
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));

        int[][] matrix2 = {
            {3, 2, 7, 6},
            {2, 4, 1, 0},
            {3, 2, 1, 0}
        };
        System.out.println(arrayAsString(matrix2));
    }
}
