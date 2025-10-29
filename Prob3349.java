import java.util.Arrays;
import java.util.List;

public class Prob3349 {

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int i = 0, j = k;
        int count = 1;
        while (i < nums.size() - k) {
            if (j + 1 < nums.size() && nums.get(i) < nums.get(i + 1) && nums.get(j) < nums.get(j + 1)) {
                count++;
                if (count == k) {
                    return true;
                }
            } else {
                count = 1;
            }
            i++; j++;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5,8,-2,-1);
        System.out.println(hasIncreasingSubarrays(nums, 2));
    }  
}
