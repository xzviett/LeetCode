public class Prob2536 {

    public static void main(String[] args) {
        int[][] ans = rangeAddQueries(3, new int[][] {
            {1,1,2,2},
            {0,0,1,1}
        });

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        for (int[] query : queries) {
            int x1 = query[0], y1 = query[1], x2 = query[2], y2 = query[3];
            diff[x1][y1] += 1;
            diff[x2 + 1][y1] -= 1;
            diff[x1][y2 + 1] -= 1;
            diff[x2 + 1][y2 + 1] += 1;
        }

        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = (i == 0) ? 0 : res[i - 1][j];
                int x2 = (j == 0) ? 0 : res[i][j - 1];
                int x3 = (i == 0 || j == 0) ? 0 : res[i - 1][j - 1];
                res[i][j] = diff[i][j] + x1 + x2 - x3;
            }
        }
        return res;
    }
}
