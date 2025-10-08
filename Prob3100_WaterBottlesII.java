public class Prob3100_WaterBottlesII {

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        int emptyBottles = numBottles, fullBottles = 0;
        while (fullBottles + emptyBottles >= numExchange) {
            while (emptyBottles >= numExchange) {
                fullBottles++;
                emptyBottles = emptyBottles - numExchange;
                numExchange++;
            }
            emptyBottles += fullBottles;
            result += fullBottles;
            fullBottles = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(3, 4));
    }
}
