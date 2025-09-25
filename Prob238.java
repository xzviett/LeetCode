import java.util.Arrays;

public class Prob238 {

    public static int[] productExceptSelf(int[] nums) {

        int numOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) 
                numOfZero++;
        }

        int[] ans = new int[nums.length];

        if (numOfZero >= 2) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = 0;
            }
            return ans;
        } else if (numOfZero == 1) {
            int res = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    res *= nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    ans[i] = res;
                } else {
                    ans[i] = 0;
                }
            }
            return ans;
        } else {
            int multiple = 1;
            for (int i = 0; i < nums.length; i++) {
                multiple *= nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                ans[i] = multiple / nums[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] ans = productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println(Arrays.toString(ans));
    }
}
