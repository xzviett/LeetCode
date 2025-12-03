import java.util.Arrays;

public class Prob875 {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        int res = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (stopCondition(piles, h, mid)) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return res;
    }

    private static boolean stopCondition(int[] piles, int h, int k) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (int) Math.ceil(1.0 * piles[i] / k);

            //if (piles[i] % k != 0) hours++;
        } 
        return hours <= h;
       
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {30,11,23,4,20}, 5));
    }
}
