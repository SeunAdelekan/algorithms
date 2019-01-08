package leetcode.easy;

/**
 * @author Iyanu Adelekan on 26/12/2018.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
    }

    /**
     * Solution to Longest Common Prefix problem.
     * Worst case time complexity: O(A * B)
     *
     * @param strArray - array of strings.
     * @return string
     */
    private static String longestCommonPrefix(final String[] strArray) {
        if (strArray == null || strArray.length == 0) {
            return "";
        }
        int min = strArray[0].length();

        for (String str : strArray) {
            min = Math.min(min, str.length());
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < min; i++) {
            char current = strArray[0].charAt(i);
            boolean stopped = false;

            for (String aStrArray : strArray) {
                if (aStrArray.charAt(i) != current) {
                    stopped = true;
                    break;
                }
            }
            if (stopped) {
                break;
            }
            builder.append(current);
        }
        return builder.toString();
    }
}
