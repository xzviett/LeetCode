import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Prob1488 {

    public static int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int n = rains.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            }
            else {
                int lake = rains[i];
                ans[i] = -1;

                if (fullLakes.containsKey(lake)) {
                    int prevRainDay = fullLakes.get(lake);
                    Integer dryDay = dryDays.higher(prevRainDay);

                    if (dryDay == null) {
                        return new int[0];
                    }

                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                fullLakes.put(lake, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(avoidFlood(new int[] {1,2,0,0,2,1})));
    }
}
