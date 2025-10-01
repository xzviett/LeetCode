import java.util.Arrays;

public class Prob973_KClosestPointstoOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        double[] distance = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int x = points[i][0];
                int y = points[i][1];
                distance[i] = getDistance(x, y);
            }
        }
        int[][] result = new int[k][2];
        quickSort(points, distance, 0, n - 1);
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }

    static void swap(int[][] point, double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        int[] temp2 = point[i];
        point[i] = point[j];
        point[j] = temp2;
    }


    static int partition(int[][] points, double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(points, arr, i, j);
            }
        }
        
        swap(points, arr, i + 1, high);  
        return i + 1;
    }

    static void quickSort(int[][] points, double[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(points, arr, low, high);
            quickSort(points, arr, low, pi - 1);
            quickSort(points, arr, pi + 1, high);
        }
    }

    public static double getDistance(int x, int y) {
        return Math.sqrt(1.0 * x * x + 1.0 * y * y);
    }

    public static void main(String[] args) {
        int[][] ans = kClosest(new int[][]{{3,3}, {5, -1}, {-2, 4}}, 2);
        System.out.println(Arrays.toString(ans));
    }
}
