package cracking;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Solutions to Cracking the Coding Interview questions on Chapter 1: Arrays and Strings
 */
public class Chapter1 {

    public static void main(String[] args) {
        System.out.println(uniqueCharacterString("#abcde"));
        System.out.println(uniqueCharacterString2("#abcde"));
    }

    /**
     * Solution to interview question 1.1
     * Worst case time complexity: O(n).
     *
     * @param str - string to check.
     * @return boolean
     */
    private static boolean uniqueCharacterString(final String str) {
        HashSet<Character> charSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (charSet.contains(currentChar)) {
                return false;
            }
            charSet.add(currentChar);
        }
        return true;
    }

    /**
     * My second solution to interview question 1.1
     * Worst case time complexity: O(n log n).
     *
     * @param str - string to be tested.
     * @return boolean
     */
    private static boolean uniqueCharacterString2(final String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        int res;
        final int start = 0;
        final int stop = str.length();

        for (char c : charArray) {
            res = binarySearch(charArray, c, start, stop);

            if (res > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Modified binary search algorithm to find the number of occurences of a char.
     * Note: This implementation only guarantees the discovery of characters occurring up to
     * two times.
     *
     * @param array - character array.
     * @param element - element to be found.
     * @param start - start position.
     * @param stop - end position.
     * @return
     */
    private static int binarySearch(
            final char[] array,
            final char element,
            final int start,
            final int stop) {
        int occurrences = 0;

        if (stop - start == 0) {
            return 0;
        }
        final int midPoint = (start + stop) / 2;

        if (array[midPoint] == element) {
            occurrences++;

            if (midPoint - 1 > -1 &&
                    (array[midPoint - 1] == element ||
                            (midPoint + 1 < array.length) && array[midPoint + 1] == element)) {
                occurrences++;
            }
        } else if (array[midPoint] < element) {
            occurrences += binarySearch(array, element, midPoint, stop);
        } else {
            occurrences += binarySearch(array, element, start, midPoint);
        }

        return occurrences;
    }

    private static char[] sortCharArray(final char[] charArray, final int start, final int end) {
        if (end - start < 2) {
            return charArray;
        }
        final int midPoint = (int) Math.floor((start + end) / 2);

        sortCharArray(charArray, start, midPoint);
        sortCharArray(charArray, midPoint + 1, charArray.length - 1);

        return mergeArrays(charArray, midPoint);
    }

    private static char[] mergeArrays(final char[] array, final int middle) {
        for (int i = 0; i < array.length; i++) {
            char temp = array[i];

            if (array[i] > array[middle + 1]) {
                array[i] = array[middle + 1];
                array[middle + 1] = temp;
            }
        }
        return array;
    }
}
