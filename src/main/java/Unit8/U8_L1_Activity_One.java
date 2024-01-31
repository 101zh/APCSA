package Unit8;

// Have to get rid of package statement

public class U8_L1_Activity_One {

    public static int sumOfDiag(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length && i < arr[i].length; i++) {
            sum += arr[i][i];
        }

        return sum;
    }

}
