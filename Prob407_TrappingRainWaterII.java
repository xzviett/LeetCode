import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob407_TrappingRainWaterII {
    private static class Cell {
        int row, col, height;
        Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }
    }

    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0; 

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.height));

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = visited[m - 1][j] = true;
        }

        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] d : dirs) {
                int r = cell.row + d[0];
                int c = cell.col + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;
                    water += Math.max(0, cell.height - heightMap[r][c]);
                    pq.offer(new Cell(r, c, Math.max(heightMap[r][c], cell.height)));
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(trapRainWater(new int[][] {{1,4,3,1,3,2},
                                                      {3,2,1,3,2,4},
                                                      {2,3,3,2,3,1}})
        );
    }
}
