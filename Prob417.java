import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob417 {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(i, 0, pacific, heights[i][0], heights);
            dfs(i, m - 1, atlantic, heights[i][m - 1], heights);
        }

        for (int i = 0; i < m; i++) {
            dfs(0, i, pacific, heights[0][i], heights);
            dfs(n - 1, i, atlantic, heights[n - 1][i], heights);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;

    }

    private static void dfs(int x, int y, boolean[][] visited, int prevHeight, int[][] heights) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length) return;
        if (visited[x][y]) return;
        if (heights[x][y] < prevHeight) return;

        visited[x][y] = true;
        for (int[] d : dir) {
            dfs(x + d[0], y + d[1], visited, heights[x][y], heights);
        }
    }

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][] {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        }));
    }
}
