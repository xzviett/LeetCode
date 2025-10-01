import java.util.Arrays;

public class Prob611_ValidTriangleNumber {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        
        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    result += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[] {2,2,3,4}));
    }
}
