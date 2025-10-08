public class Prob242_ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] fre1 = new int[26];
        int[] fre2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            fre1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            fre2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (fre1[i] != fre2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
}
