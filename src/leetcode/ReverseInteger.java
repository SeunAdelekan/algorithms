package leetcode;

/**
 * @author Iyanu Adelekan on 25/12/2018.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(234));
        System.out.println(reverse(-234));
        System.out.println(reverse(2346));
    }

    /**
     * Solution to the reverse integer problem.
     * Worst case time complexity: O(n).
     *
     * @param x - integer to be reversed.
     * @return string - reversed integer
     */
    private static int reverse(int x) {
        String value = String.valueOf(x);
        StringBuilder builder = new StringBuilder();

        if (x >= 0) {
            for (int i = value.length() - 1; i >= 0; i--) {
                builder.append(value.charAt(i));
            }
        } else {
            builder.append("-");

            for (int i = value.length() - 1; i > 0; i--) {
                builder.append(value.charAt(i));
            }
        }

        try {
            return Integer.parseInt(builder.toString());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
