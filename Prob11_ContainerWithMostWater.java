public class Prob11_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int result = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                result = Math.max(result, height[left] * (right - left));
                left++;
            } 
            else {
                result = Math.max(result, height[right] * (right - left));
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {0,0}));
    }
}
