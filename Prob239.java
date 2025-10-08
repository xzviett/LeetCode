import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Prob239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                ans[index++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
    }
}
