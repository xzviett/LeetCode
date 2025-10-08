import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prob496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] temp = new int[nums2.length];
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            temp[i] = -1;
        } 

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                temp[i] = st.peek();
            }

            st.push(nums2[i]);
        }   


        for (int i = 0; i < nums2.length; i++) {
            mp.put(nums2[i], temp[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = mp.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
}
