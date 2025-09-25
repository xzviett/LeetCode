public class Prob121 {

    public static int maxProfit(int[] prices) {
        int currentCheapest = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - currentCheapest;
            if (profit > result) {
                result = profit;
            }

            if (prices[i] < currentCheapest) {
                currentCheapest = prices[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,7,3,6};
        System.out.println(maxProfit(arr));
    }
}
