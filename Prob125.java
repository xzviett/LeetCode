public class Prob125 {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                newStr.append(c);
            }
        }
        String str = newStr.toString();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++; right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }
}
