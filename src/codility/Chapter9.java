package codility;

/**
 * @author Iyanu Adelekan on 11/08/2018.
 *
 * This chapter is on maximum slices.
 */
public class Chapter9 {

    public static void main(String[] args) {
        System.out.println(maxSlice(new int[] { 5, -7, 3, 5, -2, 4, -1 }));
    }

    /**
     * Solution to the maximum slice problem.
     * Worst case time complexity: O(n)
     * Reason: Solves the problem in a single iteration.
     *
     * @param a - array of elements.
     * @return int - maximum slice vale.
     */
    private static int maxSlice(int[] a) {
        int maxSlice = 0;
        int maxEnding = 0;

        for (int e : a) {
            maxEnding = Math.max(0, maxEnding + e);
            maxSlice = Math.max(maxSlice, maxEnding);
        }
        return maxSlice;
    }
}
