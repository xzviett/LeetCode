public class Prob53_MaximumSumArray {

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum = sum + nums[i];
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, -2, -3}));
    }
}