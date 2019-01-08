package hackerrank.challenges;

import java.util.Arrays;

/**
 * @author Iyanu Adelekan on 21/08/2018.
 */
public class ThirtyDaysOfCode {

    public static void main(String[] args) {
        binaryNumbers(439);
    }

    /**
     * Solution to Binary Numbers problem.
     * Worst case time complexity: O(n + m).
     *
     * @param n - the number to be converted to binary.
     */
    private static void binaryNumbers(int n) {
        int count = 0;
        int maxCount = 0;
        StringBuilder binary = new StringBuilder();

        while (true) {
            int remainder = n % 2;
            binary.insert(0, remainder);
            n = (int) Math.floor(n / 2);

            if (n == 0) {
                break;
            }
        }
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
                continue;
            }
            count = 0;
        }
        System.out.println(binary);
        System.out.println(maxCount);
    }
}
