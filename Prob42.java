public class Prob42 {

    public static int trap(int[] height) {
        int n = height.length;
        int left = 1, right = n - 2;
        int lMax = height[left - 1];
        int rMax = height[right + 1];
        int result = 0;
        
        while (left <= right) {
            if (rMax <= lMax) {
                result += Math.max(0, rMax - height[right]);
                rMax = Math.max(rMax, height[right]);
                right -= 1;
            } else { 
                result += Math.max(0, lMax - height[left]);
                lMax = Math.max(lMax, height[left]);
                left += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
