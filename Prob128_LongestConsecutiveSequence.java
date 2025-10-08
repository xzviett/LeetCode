import java.util.Arrays;

public class Prob128_LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) return  0;
        if (nums.length == 1) return 1;
        int result = 0, length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                length++; result = Math.max(result, length);
            } 
            else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                length = 1;
            }
        }
        return Math.max(result, length);
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
}
