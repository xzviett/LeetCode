import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Prob3186 {

    public static long maximumTotalDamage(int[] power) {
        HashMap<Integer, Long> damageMap = new HashMap<>();
        for (int i = 0; i < power.length; i++) {
            damageMap.put(power[i], damageMap.getOrDefault(power[i], 0L) + power[i]);
        }

        List<Integer> vals = new ArrayList<>();
        for (Integer pow : damageMap.keySet()) {
            vals.add(pow);
        }
        Collections.sort(vals);

        long[] dp = new long[vals.size()];
        dp[0] = damageMap.get(vals.get(0));

        for (int i = 1; i < vals.size(); i++) {
            long gain = damageMap.get(vals.get(i));

            int low = 0, high = i - 1, j = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (vals.get(mid) <= vals.get(i) - 3) {
                    j = mid;
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }

            long pick = gain + (j >= 0 ? dp[j] : 0);
            long noPick = dp[i - 1];
            dp[i] = Math.max(pick, noPick);
        }

        return dp[vals.size() - 1];
    }

    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new int[] {7,1,6,6}));
    }
}
