public class ArrayUtils {
    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        
        for (int[] row : array) {
            for (int num : row) {
                sb.append(num);
            }
            sb.append(System.lineSeparator());
        }
        
        return sb.toString().trim(); 
    }

}
