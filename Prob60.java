import java.util.List;
import java.util.ArrayList;

public class Prob60 {

    public static String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();

        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial[i] = factorial[i - 1] * i;
        }

        k -= 1;
        for (int i = n; i >= 1; i--) {
            int block_size = factorial[i - 1];
            int index = k / block_size;
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= block_size;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }
}
