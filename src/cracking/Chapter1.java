package cracking;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Solutions to Cracking the Coding Interview questions on Chapter 1: Arrays and Strings
 */
public class Chapter1 {

    public static void main(String[] args) {
        System.out.println(uniqueCharacterString("#abcde"));
        System.out.println(uniqueCharacterString2("#abcde"));

        System.out.println(isPermutation("adelekan", "nakeleda"));
        System.out.println(formatURL("https://www.goo gle.com"));
        System.out.println(isPalindrome2("Nurses run"));
        System.out.println(oneAway("pale", "bake"));
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
     * Solution to interview question 1.2
     * Worst case time complexity: O(n).
     *
     * @param str1 - first string.
     * @param str2 - second string.
     * @return boolean
     */
    private static boolean isPermutation(final String str1, final String str2) {
        final char[] array1 = str1.toCharArray();
        final char[] array2 = str2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    /**
     * Solution to interview question 1.3
     * Worst case time complexity: O(n).
     *
     * @param url - url to be formatted.
     * @return String - formatted url.
     */
    private static String formatURL(final String url) {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < url.length(); i++) {
            char value = url.charAt(i);

            if (value == ' ') {
                builder.append("%20");
                continue;
            }
            builder.append(value);
        }
        return builder.toString();
    }

    /**
     * Buggy solution to the palindrome permutation problem (1.4).
     * This is an attempt to solve it without a data structure.
     * Worst case time complexity: O(n).
     *
     * TODO Debug and finish method.
     *
     * @param str - string to be checked.
     * @return boolean - true if is a palindrome and false otherwise.
     */
    private static boolean isPalindrome(final String str) {
        boolean foundLoneChar = false;
        int count = 0;
        char currentChar;

        final char[] strChars = str.toLowerCase().toCharArray();
        Arrays.sort(strChars);

        System.out.println(strChars);

        currentChar = strChars[0];
        count++;

        for (int i = 1; i < strChars.length; i++) {
            if (strChars[i] != ' ') {
                if (strChars[i] == currentChar) {
                    count++;
                    currentChar = strChars[i];
                    continue;
                }
                if (count % 2 == 1 && !foundLoneChar) {
                    foundLoneChar = true;
                } else if (count % 2 == 1 && foundLoneChar) {
                    return false;
                }
                currentChar = strChars[i];
                count = 1;
            }
        }
        return true;
    }

    /**
     * Working solution to the palindrome permutation problem (1.4).
     * Worst case time complexity: O(n).
     *
     * @param str - string to be checked.
     * @return boolean - true if is a palindrome and false otherwise.
     */
    private static boolean isPalindrome2(final String str) {
        if (str.length() == 1 && !str.equals(" ")) {
            return true;
        }

        final char[] array = str.toLowerCase().toCharArray();
        HashMap<Character, Integer> map = getCharacterMap(array);
        AtomicInteger oddCount = new AtomicInteger(0);

        map.forEach((key, val) -> {
            if (val % 2 == 1) {
                oddCount.set(oddCount.get() + 1);
            }
        });
        return !(oddCount.get() > 1);
    }

    /**
     * Solution to interview question 1.5
     * Worst case time complexity: O(n).
     *
     * @param str1 - comparing string.
     * @param str2 - compared.
     * @return boolean - true if str2 can be converted to str1 in a change or less.
     */
    private static boolean oneAway(final String str1, final String str2) {
        if (str2.equals("") && str1.length() > 1) {
            return false;
        }

        int changes = 0;
        final char[] array1 = str1.toCharArray();
        final char[] array2 = str2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);
        final List<Character> list = toCharacterList(array2);

        for (int i = 0; i < array1.length; i++) {
            if (i > list.size() - 1) {
                list.add(array1[i]);
                continue;
            }
            char current = list.get(i);

            if (!(array1[i] == current)) {
                if (array1[i] < current) {
                    list.add(i, array1[i]);
                } else if (array1[i] > current) {
                    list.remove(i);
                }
                changes++;
            }
        }
        return changes <= 1;
    }

    private static List<Character> toCharacterList(final char[] array) {
        final List<Character> list = new ArrayList<>();

        for (char c : array) {
            list.add(c);
        }
        return list;
    }

    private static HashMap<Character, Integer> getCharacterMap(final char[] array) {
        HashMap<Character, Integer> map = new HashMap<>();

        IntStream.range(0, array.length).forEach(index -> {
            char key = array[index];

            if (key != ' ') {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                    return;
                }
                int count = map.get(key);

                map.put(key, ++count);
            }
        });
        return map;
    }

    /**
     * Modified binary search algorithm to find the number of occurrences of a char.
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
