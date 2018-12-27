package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Iyanu Adelekan on 26/12/2018.
 */
public class StringToInteger {

    private static char[] validChars = new char[] { '-', '+', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private static Set<Character> set = new HashSet<>();

    static {
        for (char validChar : validChars) {
            set.add(validChar);
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" -12 793992020202034"));
    }

    /**
     * Solution to String To Integer problem.
     * Worst case time complexity: O(n).
     *
     * @param str - string to be converted.
     * @return int - corresponding integer of string.
     */
    private static int myAtoi(final String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == ' ') {
                if (result.length() == 0) {
                    continue;
                }
                break;
            }
            if (!set.contains(current)) {
                break;
            }
            if ((current == '-' || current == '+') && result.length() == 0) {
                result.append(String.valueOf(current));
            } else if (current == '-' || current == '+') {
                break;
            } else {
                result.append(String.valueOf(current));
            }
        }
        if (result.length() == 0) {
            return 0;
        }
        String resultString = result.toString();
        if (resultString.equals("+") || resultString.equals("-")) {
            return 0;
        }

        try {
            return Integer.parseInt(resultString);
        } catch (NumberFormatException ex) {
            if (result.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }
}
