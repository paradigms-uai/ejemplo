package exercise4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by federicodonnarumma on 8/26/15.
 */
public class BalanceChecker {

    public boolean isBalanced(String expression) {
        char c;
        List stack = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = (char) stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
                if (pop == '{' && c != '}' ||
                    pop == '(' && c != ')' ||
                    pop == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
