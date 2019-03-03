package hackerrank.interview;

import java.util.HashMap;
import java.util.Map;

public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
    }

    private static long repeatedString(String str, long n) {
        if (n == 0) {
            return 0;
        }
        long count;
        final Map<Integer, Integer> map = generateMap(str);

        if (n <= str.length()) {
            return map.get((int) n);
        }
        long multiplier = n / (long) str.length();
        long remainder = n % (long) str.length();

        count = (map.get(str.length()) * multiplier);

        if (remainder != 0) {
            count += map.get((int)remainder);
        }

        return count;
    }

    private static Map<Integer, Integer> generateMap(final String str) {
        int count = 0;
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
            map.put(i + 1, count);
        }
        return map;
    }
}
