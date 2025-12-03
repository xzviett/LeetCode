public class Prob1578 {

    public static int minCost(String colors, int[] neededTime) {
        int result = 0;
        for (int i = 1; i < neededTime.length; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                result += Math.min(neededTime[i - 1], neededTime[i]);
                neededTime[i] = Math.max(neededTime[i - 1], neededTime[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minCost("abaac", new int[] {1,2,3,4,5}));
    }
}
