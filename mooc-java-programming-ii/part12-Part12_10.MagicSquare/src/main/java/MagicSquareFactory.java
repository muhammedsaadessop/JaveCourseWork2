public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        if (size % 2 == 0) {
            throw new IllegalArgumentException("Size must be an odd number.");
        }

        MagicSquare square = new MagicSquare(size);
        int[][] grid = new int[size][size];
        int num = 1;
        int row = 0;
        int col = size / 2;

        while (num <= size * size) {
            grid[row][col] = num++;
            int newRow = (row - 1 + size) % size;
            int newCol = (col + 1) % size;
            if (grid[newRow][newCol] != 0) {
                row = (row + 1) % size;
            } else {
                row = newRow;
                col = newCol;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                square.placeValue(j, i, grid[i][j]);
            }
        }

        return square;
    }
}
