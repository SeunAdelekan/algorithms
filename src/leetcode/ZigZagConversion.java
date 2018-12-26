package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iyanu Adelekan on 26/12/2018.
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    /**
     * Solution to zig zag conversion problem.
     * Worst case time complexity: O(A * B).
     *
     * @param str - string to be converted.
     * @param rows - number of rows.
     * @return String - converted string.
     */
    private static String convert(String str, int rows) {
        final List<List<Character>> list = new ArrayList<>();
        initList(list, rows);
        int currentRow = 0;
        boolean ascending = true;

        for (int i = 0; i < str.length(); i++) {
            list.get(currentRow).add(str.charAt(i));

            if (rows == 1) {
                continue;
            }
            if (currentRow == rows - 1) {
                ascending = false;
            }
            if (currentRow == 0 && !ascending) {
                ascending = true;
            }
            if (ascending) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        return buildString(list);
    }

    private static String buildString(List<List<Character>> lists) {
        final StringBuilder builder = new StringBuilder();

        lists.forEach(list -> list.forEach(builder::append));
        return builder.toString();
    }

    private static void initList(List<List<Character>> list, int rows) {
        for (int i = 0; i < rows; i++) {
            list.add(new ArrayList<>());
        }
    }
}
