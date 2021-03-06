import java.util.Stack;

public class DecodeString {
    public static String decode(String code) {
        var numStack = new Stack<Integer>();
        var strStack = new Stack<StringBuilder>();
        var num = 0;
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < code.length(); i++) {
            var c = code.charAt(i);
            if (Character.isDigit(c)) {
                num += Character.getNumericValue(c);
                if (Character.isDigit(code.charAt(i + 1))) {
                    num *= 10;
                } else {
                    numStack.push(num);
                    num = 0;
                }
            } else if (c == '[') {
                strStack.push(sb);
                sb = new StringBuilder("");
            } else if (c == ']') {
                StringBuilder temp = strStack.pop();
                temp.append(String.valueOf(sb).repeat(Math.max(0, numStack.pop())));
                sb = temp;
            } else if (Character.isLetter(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main (String[] args) {
        System.out.println(DecodeString.decode("101[a29[c]]"));
    }
}