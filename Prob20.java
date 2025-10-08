import java.util.Stack;

public class Prob20 {

    public static boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < c.length) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                st.push(c[i]);
            }
            if (c[i] == ')' || c[i] == '}' || c[i] == ']') {
                if (st.isEmpty()) return false;
                char prev = st.pop();
                if (prev == '(' && c[i] != ')') return false;
                if (prev == '{' && c[i] != '}') return false;
                if (prev == '[' && c[i] != ']') return false;
                
            }
            i++;
        }
        return st.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
