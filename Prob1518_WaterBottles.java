public class Prob1518_WaterBottles {

    public static int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) return numBottles;

        int filledBottles = numBottles, emptyBottles = numBottles, result = numBottles; 
        while (emptyBottles >= numExchange) {
            filledBottles = emptyBottles / numExchange;
            result += filledBottles;
            emptyBottles = emptyBottles % numExchange + filledBottles;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4));
    }
}
