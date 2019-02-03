package honeypot;

import java.util.*;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class Solution {

    private static List<String> permutations = new ArrayList<>();
    private static Set<String> prefixes = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(rearrangeWord("baca"));
    }

    private static String rearrangeWord(final String word) {
        generatePermutations(word, "", word);
        Collections.sort(permutations);
        System.out.println(permutations);
        boolean foundWord = false;

        for (int i = 0; i < permutations.size(); i++) {
            if (permutations.get(i).equals(word)) {
                foundWord = true;
            }
            if (foundWord && !permutations.get(i).equals(word)) {
                return permutations.get(i);
            }
        }
        return "no answer";
    }

    /**
     *
     * @param word
     * @param prefix
     * @param str
     */
    private static void generatePermutations(String word, final String prefix, final String str) {
        int length = str.length();

        if (length == 0) {
            permutations.add(prefix);
            return;
        }
        for (int i = 0; i < length; i++) {
            System.out.println(prefix);
            if (!prefix.equals("")
                    && prefix.compareTo(word.substring(0, prefix.length() - 1)) < 0
                    && !prefixes.contains(prefix))
                continue;

            prefixes.add(prefix);
            generatePermutations(
                    word,
                    prefix + str.charAt(i),
                    str.substring(0, i) + str.substring(i + 1, length)
            );
        }
    }
}
