public class Prob2221_FindTriangularSumofArray {

    public static int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }

        for (int i = 0; i < ans.length - 1; i++) {
            for (int j = 0; j < ans.length - i - 1; j++) {
                ans[j] = (ans[j] + ans[j + 1]) % 10;
            }
        }
        return ans[0] % 10;
    }

    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1,2,3,4,5}));
    }
}
