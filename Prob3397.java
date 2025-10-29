import java.util.Arrays;

public class Prob3397 {

    public static int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 1;

        nums[0] -= k;
        //nums[n - 1] = (n > 1) ? nums[n - 1] + k : nums[n - 1] - k;

        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(Math.max(nums[i] - k, nums[i - 1] + 1), nums[i] + k);
            if (nums[i] > nums[i - 1]) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(maxDistinctElements(new int[] {1,2,2,3,3,4}, 2));
    }
}
