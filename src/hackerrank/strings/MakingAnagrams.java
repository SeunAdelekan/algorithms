package hackerrank.strings;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Iyanu Adelekan on 21/08/2018.
 */
public class MakingAnagrams {

    public static void main(String[] args) {
        System.out.println(makeAnagrams("cde", "abc"));
    }

    /**
     * Solution to HackerRank's 'Making Anagrams' problem.
     * Worst case time complexity: O(n + m).
     *
     * @param str1 - first string.
     * @param str2 - second string.
     * @return int - number of changes required to make the two strings anagrams.
     */
    private static int makeAnagrams(final String str1, final String str2) {
        int changes = 0;
        final TreeMap<Character, Integer> map1 = generateMap(str1);
        final TreeMap<Character, Integer> map2 = generateMap(str2);

        changes += spotChanges(map1, map2);
        changes += spotChanges(map2, map1);

        return changes;
    }

    /**
     * Spots the changes required to make a map equal to another.
     *
     * @param map1 - map to be made equal.
     * @param map2 - second map.
     * @return int - number of changes required.
     */
    private static int spotChanges(final TreeMap<Character, Integer> map1, final TreeMap<Character, Integer> map2) {
        final AtomicInteger changes = new AtomicInteger(0);

        map1.forEach((key, val) -> {
            if (!map2.containsKey(key)) {
                updateAtom(changes, val);
            } else {
                if (val > map2.get(key)) {
                    updateAtom(changes, val - map2.get(key));
                }
            }
        });
        return changes.get();
    }

    /**
     * Helper method to neatly increase the value of an AtomicInteger by an integer.
     *
     * @param atom - AtomicInteger to be updated.
     * @param value - value to increase atomic integer by.
     */
    private static void updateAtom(final AtomicInteger atom, int value) {
        atom.set(atom.get() + value);
    }

    /**
     * Generates  corresponding TreeMap for a given string.
     *
     * @param str - string whose TreeMap is to be generated.
     * @return TreeMap - generated TreeMap.
     */
    private static TreeMap<Character, Integer> generateMap(final String str) {
        final char[] arr = str.toCharArray();
        final TreeMap<Character, Integer> map = new TreeMap<>();

        for (char c : arr) {
            if (map.containsKey(c)) {
                int value = map.get(c);
                map.put(c, ++value);
                continue;
            }
            map.put(c, 1);
        }
        return map;
    }
}
