package hackerrank.hashtables;

import java.util.HashSet;

/**
 * @author Iyanu Adelekan on 12/08/2018.
 */
public class TwoStrings {

    public static void main(String[] args) {
        System.out.println(testStrings("hello", "world"));
        System.out.println(testStrings("hi", "world"));
    }

    private static String testStrings(final String a, final String b) {
        final HashSet<Character> setA = new HashSet<>();

        for (char c : a.toCharArray()) {
            setA.add(c);
        }
        for (char c : b.toCharArray()) {
            if (setA.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }
}
