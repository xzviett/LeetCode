import java.util.Arrays;

public class Prob189_RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int first, int last) {
        int i = first, j = last;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1,-100,3,99};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
