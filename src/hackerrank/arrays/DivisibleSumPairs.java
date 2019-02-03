package hackerrank.arrays;

import java.util.Arrays;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class DivisibleSumPairs {

    public static void main(String[] args) {
        final int[] data = new int[] { 1, 3, 2, 6, 1, 2 };

        System.out.println(divisibleSumPairs(6, 3, data));
    }

    private static int divisibleSumPairs(int n, int k, int[] array) {
        Arrays.sort(array);
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i] + array[j]) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
