package leetcode.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    private static boolean isValid(final String str) {
        if (str.length() == 0) {
            return true;
        }
        if (str.length() == 1) {
            return false;
        }
        final Stack<Character> stack = new Stack<>();
        char prev = str.charAt(0);
        char current;
        stack.push(prev);

        for (int i = 1; i < str.length(); i++) {
            current = str.charAt(i);

            if (prev == '(' && current == ')' || prev == '[' && current == ']' || prev == '{' && current == '}') {
                stack.pop();

                if (!stack.empty()) {
                    prev = stack.peek();
                }
            } else {
                stack.push(current);
                prev = current;
            }
        }
//        System.out.println(stack);

        return stack.empty();
    }
}
