import java.util.Scanner;
public class Prob9_PalindromeNumber {

    public static int reverse(int x) {
        int num = x;
        int result = 0;
        while (num > 0) {
            int digit = num % 10;
            result = result * 10 + digit;
            num /= 10;
        }
        return result;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == reverse(x)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.println(isPalindrome(x));
        scan.close();
    }
}
