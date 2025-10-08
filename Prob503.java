import java.util.Arrays;
import java.util.Stack;

public class Prob503 {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (!st.empty() && i < n) {
                result[i] = st.peek();
            }

            st.push(nums[i % n]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {1,2,3,4,3})));
    }
}
