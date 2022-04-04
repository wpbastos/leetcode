import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String expression) {
        if (expression == null || expression.length() == 0) {
            return false;
        }

        Stack<Character> s = new Stack<>();
        for (int i = 0; i <= expression.length() - 1; i++) {
            char c = expression.charAt(i);
            if (c == '{' || c == '(' || c == '[' ) {
                s.push(c);
            } else if (c == '}' || c == ')' || c == ']' ) {
                if (s.empty()) return false;
                char open = s.pop();
                if (open == '{' && c == '}') continue;
                else if (open == '(' && c == ')') continue;
                else if (open == '[' && c == ']') continue;
                else return false;
            }
        }

        return s.empty();
    }

    public static void main (String[] args) {
        System.out.println(BalancedParentheses.isBalanced("(q{w[e]})"));
    }

}
