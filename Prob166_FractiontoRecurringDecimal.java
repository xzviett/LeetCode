//NOT DONE YET, THIS QUESTION IS FUKING TRICKY!!!

import java.util.HashMap;
import java.util.Map;

public class Prob166_FractiontoRecurringDecimal {

    public static boolean primeFactorize(int n) {
        long num = n;
        if (num < 0) num *= -1;
        while (num % 2 == 0) {
            num /= 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            while (num % i == 0) {
                if (i != 2 && i != 5) {
                    return true;
                }
                num /= i;
            }
        }
        if (num > 2) {
            if (num != 2 && num != 5) return true;
        }
        return false;
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (primeFactorize(denominator)) {
            int prevNumerator = numerator;
            int prevDenominator = denominator;
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
            
            StringBuilder result = new StringBuilder();

            int integerPart = numerator / denominator;
            result.append(integerPart);

            int remainder = numerator % denominator;

            result.append(".");
            Map<Integer, Integer> remainderMap = new HashMap<>();
            StringBuilder fractionPart = new StringBuilder();

            while (remainder != 0) {
                if (remainderMap.containsKey(remainder)) {
                    int start = remainderMap.get(remainder);
                    fractionPart.insert(start, "(");
                    fractionPart.append(")");
                    result.append(fractionPart);
                    if ((prevNumerator < 0 && prevDenominator > 0) || (prevNumerator > 0 && prevDenominator < 0)) {
                        StringBuilder s = new StringBuilder();
                        s.append("-");
                        s.append(result); 
                        return s.toString();
                    }
                    return result.toString();
                }

                remainderMap.put(remainder, fractionPart.length());
                remainder *= 10;
                fractionPart.append(remainder / denominator);
                remainder %= denominator;
            }
            result.append(fractionPart);
            if ((prevNumerator < 0 && prevDenominator > 0) || (prevNumerator > 0 && prevDenominator < 0)) {
                StringBuilder s = new StringBuilder();
                s.append("-");
                s.append(result); 
                return s.toString();
            }
            return result.toString();
        }

        if (numerator % denominator == 0) 
            return Integer.toString(numerator / denominator);

        return Double.toString(1.0 * numerator / denominator);
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1, -2147483648));
        System.out.println(primeFactorize(-2147483648));
    }
}
