import java.util.HashMap;
import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String expression) {
        if (expression == null || expression.length() == 0) {
            return false;
        }

        var s = new Stack<Character>();
        var hm = new HashMap<Character, Character>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (hm.containsValue(c) ) { // open
                s.push(c);
            } else if (hm.containsKey(c)) {
                if (s.empty()) return false;
                char open = s.pop();
                if (hm.get(c) != open) return false; // not close
            }
        }

        return s.empty();
    }

    public static void main (String[] args) {
        System.out.println(BalancedParentheses.isBalanced("(q{w[e]})"));
    }

}
