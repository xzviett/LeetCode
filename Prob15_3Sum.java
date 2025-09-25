import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob15_3Sum {

    public static int binarySearch(int[] arr, int left, int right, int x) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> se = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<Integer> triplets;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int index = binarySearch(nums, j + 1, nums.length - 1, -nums[i] - nums[j]);
                triplets = new ArrayList<>();
                if (index != -1) {
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[index]);
                }
                if (triplets.size() != 0) {
                    if (!se.contains(triplets)) {
                        result.add(triplets);
                        se.add(triplets);
                    }
                    
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }    
}
