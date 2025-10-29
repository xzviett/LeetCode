import java.util.Arrays;

public class Prob3147 {

    public static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] prefix = new int[n];
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i - k >= 0) {
                prefix[i] = Math.max(prefix[i - k] + energy[i], energy[i]);
            }
            else {
                prefix[i] = energy[i];
            }
            if (i >= n - k) {
                result = Math.max(result, prefix[i]);
            }
        }
        System.out.println(Arrays.toString(prefix));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumEnergy(new int[] {-2,-3,-1}, 2));
    }  
}
