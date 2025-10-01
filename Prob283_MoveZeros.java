import java.util.Arrays;

public class Prob283_MoveZeros {

    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 7, 0, 0, 1, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
