public class Prob485_MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
                result = Math.max(result, temp);
            }
                
            if (nums[i] == 0)
                temp = 0;
        }
    
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1}));
    }
}
