import java.util.HashMap;

public class Prob424 {

    public static int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int currLength = 0;
        int maxFreq = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (; j < s.length(); j++) {
            char c = s.charAt(j);  
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            currLength = j - i + 1;

            if (currLength - maxFreq > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
                currLength = j - i + 1;
            }
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
