import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob778 {

    
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {grid[0][0], 0, 0});
        int maxHeight = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0], x = curr[1], y = curr[2];
            maxHeight = Math.max(maxHeight, h);

            if (x == n-1 && y == n-1) {
                return maxHeight;
            }
            
            if (visited[x][y]) continue;

            visited[x][y] = true;
            
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    pq.add(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        System.out.println(swimInWater(new int[][] {
            {0, 1, 2, 3, 4},
            {24,23,22,21,5},
            {12,13,14,15,16},
            {11,17,18,19,20},
            {10,9, 8, 7, 6}
        }));
    }
}
