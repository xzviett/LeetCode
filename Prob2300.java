import java.util.Arrays;

public class Prob2300 {

    private static int bSearch(int[] arr, int x) {
        int left = 0, right = arr.length; 
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < x) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }
        return left;
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        int[] ans = new int[spells.length];
        
        for (int i = 0; i < spells.length; i++) {
            int index = bSearch(potions, (int) Math.ceil(1.0  * success / spells[i]));
            System.out.println(index);
            //System.out.println((int) Math.ceil(1.0  * success / spells[i]));
            if (index == potions.length) {
                ans[i] = 0;
            } else {
                ans[i] = potions.length - index;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(new int[] {5,1,3}, new int[] {1,2,3,4,5}, 7)));
    }
}
