public class Prob812_LargestTriangleArea {

    public static double largestTriangleArea(int[][] points) {
        double result = 0;
        int numOfPoints = points.length;
        for (int i = 0; i < numOfPoints - 2; i++) {
            for (int j = i + 1; j < numOfPoints - 1; j++) {
                for (int k = j + 1; k < numOfPoints; k++){
                    result = Math.max(result, getArea(points[i], points[j], points[k]));
                }
            }
        }
        return result;
    }

    public static double getArea(int[] a, int[] b, int[] c) {
        return Math.abs(a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2;
    }

    public static void main(String[] args) {
        
    }
}
