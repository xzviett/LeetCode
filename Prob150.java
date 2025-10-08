import java.util.Stack;

public class Prob150 {

    private static int calc(String op, int operand1, int operand2) {
        if (op.equals("+")) {
            return operand1 + operand2;
        } else if (op.equals("-")) {
            return operand2 - operand1;
        } else if (op.equals("*")) {
            return operand1 * operand2;
        } else {
            return operand2 / operand1;
        }
    }

    public static int evalRPN(String[] tokens) {

        //Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if (operands.size() >= 2) {
                    String op = tokens[i];
                    int operand1 = operands.pop();
                    int operand2 = operands.pop();
                    int eval = calc(op, operand1, operand2);
                    operands.push(eval);
                }
            } else {
                operands.push(Integer.parseInt(tokens[i]));
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
