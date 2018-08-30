package leetcode;

import java.util.HashSet;

/**
 * @author Iyanu Adelekan on 30/08/2018.
 */
public class LongestNonRepeatingSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("helloworld"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int count = 0, maxCount = 0;
        final HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length() && maxCount < s.length() - i; i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (!set.contains(c)) {
                    set.add(c);
                    count++;
                    maxCount = count > maxCount ? count : maxCount;

                    continue;
                }
                set.clear();
                count = 0;
                break;
            }
        }
        return maxCount;
    }
}
