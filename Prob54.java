import java.util.ArrayList;
import java.util.List;

public class Prob54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> answer = new ArrayList<>();

        int top = 0, bottom = m - 1, left = 0, right = n - 1, direction = 0;
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    answer.add(matrix[top][i]);
                }
                direction = 1;
                top++;
            } else if(direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    answer.add(matrix[i][right]);
                }
                direction = 2;
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    answer.add(matrix[bottom][i]);
                }
                direction = 3;
                bottom--;
            } else {
                for (int i = bottom; i >= top; i--) {
                    answer.add(matrix[i][left]);
                }
                direction = 0;
                left++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][] {
            {1,2, 3, 4},
            {5,6, 7, 8},
            {9,10,11,12}
        }));
    }
}
