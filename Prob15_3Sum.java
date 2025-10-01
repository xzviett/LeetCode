import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left != right) {
                if (left >= i + 2 && nums[left] == nums[left - 1]) {
                    left++; continue;
                }
                if (right < n - 2 && nums[right] == nums[right + 1]) {
                    right--; continue;
                }
                if (nums[left] + nums[right] <= (- nums[i])) {
                    if (nums[left] + nums[right] == -nums[i]) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        
                        result.add(triplet);
                    }
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }    
}
