public class Prob48 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
    
    public static void main(String[] args) {
        rotate(new int[][] {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13,3, 6, 7},
            {15,14,12,16}
        });

        rotate(new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        });
    }
}
