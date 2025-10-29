import java.util.Arrays;

public class Prob167 {

    private static int bSearch(int[] num, int left, int right, int x) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == x) {
                return mid;
            } 
            else if (num[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = bSearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index != -1) {
                result[0] = i + 1;
                result[1] = index + 1;
            } 
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
    }
}
