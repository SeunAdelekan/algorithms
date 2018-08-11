package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Iyanu Adelekan on 11/08/2018.
 *
 * This chapter is on an array Leader.
 */
public class Chapter8 {

    public static void main(String[] args) {
        System.out.println(fastLeader(new int[] { 4, 6, 6, 6, 6, 8 }));
        System.out.println(fastLeader2(new int[] { 4, 6, 6, 6, 6, 8 }));
    }

    /**
     * My solution to the leader problem.
     * A leader of an array is an element that occurs more than
     * n/2 times in the array where n is the size of the array.
     *
     * Worst case time complexity: O(n log n).
     * Reason: The portion of this algorithm that takes the most time
     * is the sorting process which likely makes use of an algorithm
     * that sorts in  O(n log n).
     *
     * Storing the values within the HashMap is done in O(n).
     *
     * Cons of this implementation: It is not the most space efficient
     * solution as all values must additionally be kept in a HashMap. This
     * adds another O(n) of space that must be used.
     *
     * @param a - the array of numbers.
     * @return int - the value of the leader if one exists otherwise -1 is returned.
     */
    private static int fastLeader(final int[] a) {
        final HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        ArrayList<HashMap.Entry<Integer, Integer>> set = new ArrayList<>(map.entrySet());
        set.sort((e1, e2) -> {
            int value1 = e1.getValue();
            int value2 = e2.getValue();

            return Integer.compare(value1, value2);
        });
        System.out.println(set); // print the list.
        HashMap.Entry<Integer, Integer> candidate = set.get(set.size() - 1);

        return candidate.getValue() > Math.floor(a.length / 2) ? candidate.getKey() : -1;
    }

    /**
     * Improvement on original fastLeader algorithm.
     * Worst case time complexity: O(n log n).
     * Reason: Utilizes the Arrays#sort function which sorts in O(l log n).
     *
     * Pros:
     * - Uses far less space than the original implementation.
     * - It makes use of no additional data structures besides the original array hence
     *   less overhead due to function calls, etc.
     * - It is more readable than the original implementation.
     * - Way less verbose.
     *
     * @param a - the array of numbers.
     * @return int - the value of the leader if one exists otherwise -1 is returned.
     */
    private static int fastLeader2(final int[] a) {
        Arrays.sort(a);
        int count = 0;
        int middle = (int) Math.floor(a.length / 2);
        int candidate = a[middle];

        for (int e : a) {
            if (e == candidate) {
                count++;
            }
        }
        return count > Math.floor(a.length / 2) ? candidate : -1;
    }
}
