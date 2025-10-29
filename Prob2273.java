import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob2273 {

    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        List<Map<Character, Integer>> freq = new ArrayList<>();
        for (String w : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : w.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            freq.add(map);
        }

        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!freq.get(i).equals(freq.get(i - 1))) {
                result.add(words[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[] {"abba","baba","bbaa","cd","cd"}));
    }
}