package Unit8;

// Have to get rid of package statement

public class U8_L1_Activity_Two {

    public static int[][] productTable(int rows, int cols) {
        int[][] table = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = i * j;
            }
        }

        return table;
    }
}
