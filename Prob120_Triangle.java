import java.util.ArrayList;
import java.util.List;

public class Prob120_Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][triangle.get(n - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int m = triangle.get(i).size();
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                else if (j == m - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } 
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            result = Math.min(result, dp[n - 1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));
    }
}
