package hackerrank.arrays;

import java.util.*;

/**
 * @author Iyanu Adelekan on 25/02/2019.
 */
public class MinimumSwapsRefactor {

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[] { 7, 1, 3, 2, 4, 5, 6 }));
        System.out.println(minimumSwaps(new int[] { 4, 3, 1, 2 }));
        System.out.println(minimumSwaps(new int[] { 2, 3, 4, 1, 5 }));
    }

    private static int minimumSwaps(final int[] array) {
        TreeMap<Integer, Integer> map = getValueMap(array);
        int index = 0;
        int swapCount = 0;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        for (int i = 0; i < array.length - 1; i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);

            if (array[index] != entry.getKey()) {
                int temp = array[index];
                int key = entry.getKey();
                array[index] =  key;
                array[entry.getValue()] = temp;
                map.put(temp, entry.getValue());
                swapCount++;
            }
            index++;
        }
        return swapCount;
    }

    /**
     * Generates map of value => index.
     *
     * @param array - array of values.
     * @return [TreeMap]
     */
    private static TreeMap<Integer, Integer> getValueMap(final int[] array) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        return  map;
    }
}
