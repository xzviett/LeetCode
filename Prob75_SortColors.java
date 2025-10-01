import java.util.Arrays;

public class Prob75_SortColors {

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int[] fre = new int[3];
        for (int i = 0; i < n; i++) {
            fre[nums[i]]++;
        }
        for (int i = 0; i < fre[0]; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < fre[1]; i++) {
            nums[fre[0] + i] = 1;
        }
        for (int i = 0; i < fre[2]; i++) {
            nums[fre[0] + fre[1] + i] = 2;
        }
        
    }   

    public static void main(String[] args) {
        int[] nums = new int[] {2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
