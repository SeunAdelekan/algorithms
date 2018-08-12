package hackerrank.hashtables;

import java.util.HashMap;

/**
 * @author Iyanu Adelekan on 12/08/2018.
 */
public class RansomNote {

    public static void main(String[] args) {
        String[] magazine = new String[] { "two", "times", "three", "is", "not", "four" };
        String[] note = new String[] { "two", "times", "two", "is", "four" };

        checkMagazine(magazine, note);
    }

    /**
     * Solution to ransom note problem utilising a HashMap.
     * Worst case time complexity: O(n * m).
     *
     * @param magazine - the magazine
     * @param note - the note to be created.
     */
    private static void checkMagazine(final String[] magazine, final String[] note) {
        final HashMap<String, Integer> map = new HashMap<>();

        for (String word : magazine) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
                continue;
            }
            map.put(word, map.get(word) + 1);
        }

        for (String word : note) {
            if (!map.containsKey(word) || map.get(word) == 0) {
                System.out.println("No");
                return;
            }
            map.put(word, map.get(word) - 1);
        }
        System.out.println("Yes");
    }
}
