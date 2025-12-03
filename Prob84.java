import java.util.Stack;

public class Prob84 {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); 

        int n = heights.length;
        int[] left = new int[n]; 
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            result = Math.max(result, heights[i] * width);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }
}
