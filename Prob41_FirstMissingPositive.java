public class Prob41_FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        //IDEA: iterate through array: 
        //If current num <= 0 OR num > n -> do nothing
        //If current num > 0 AND cum <= n -> move current num to the exact value position
        //Missing number is the pos that do not have the same value

        int index = 0;
        while (index < nums.length) {
            while (nums[index] > 0 && nums[index] <= nums.length && nums[nums[index] - 1] != nums[index]) {
                int temp = nums[nums[index] - 1];
                nums[nums[index] - 1] = nums[index];
                nums[index] = temp;
            }
            index++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }  
    //1, 2, 0
    //3,4,-1,1
    //7,8,9,11,12

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1}));
    }
}
