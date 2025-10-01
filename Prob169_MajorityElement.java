public class Prob169_MajorityElement {

    public static int majorityElement(int[] nums) {
        int result = 0;

        for (int bit = 0; bit < 32; bit++) {
            int mask = 1 << bit;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }

            if (count > nums.length / 2) {
                result |= mask;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
    }
}
