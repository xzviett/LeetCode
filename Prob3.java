import java.util.Arrays;

public class Prob3 {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        //Gan cho tat ca ki tu flag -1 (chua gap baoh)
        Arrays.fill(charIndex, -1);
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            //Nếu gặp thằng if này tức là đã từng gặp kí tự right này rồi
            //Và mảng này vẫn lưu chỉ số cũ của thằng right trước (do chưa đc cập nhật)
            if (charIndex[s.charAt(right)] >= left) {
                //Gán chỉ số left = index của thằng bị trùng + 1
                left = charIndex[s.charAt(right)] + 1;
            }
            //Duyet qua ki tu thu right va gan index cua ki tu vao charIndex
            charIndex[s.charAt(right)] = right;
            //Cap nhat max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
