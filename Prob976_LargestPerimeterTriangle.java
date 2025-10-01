import java.util.Arrays;

public class Prob976_LargestPerimeterTriangle {

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                result = nums[i] + nums[i - 1] + nums[i - 2];
                break;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[] {2,1,2}));
    }
}
