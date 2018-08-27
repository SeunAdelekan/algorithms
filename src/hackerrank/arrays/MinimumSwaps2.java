package hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Todo Finish up solution.
 */
public class MinimumSwaps2 {

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[] { 7, 1, 3, 2, 4, 5, 6 }));
    }

    private static int minimumSwaps(final int[] arr) {
        int index = 0;
        int swapCount = 0;
        final TreeMap<Integer, List<Integer>> valueMap = getValueMap(arr);
        final List<Map.Entry<Integer, List<Integer>>> entries = new ArrayList<>(valueMap.entrySet());

        System.out.println(entries);

        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            List<Integer> indices = entry.getValue();

            for (Integer currentIndex : indices) {

                if (currentIndex != index && arr[index] != arr[currentIndex]) {
                    int temp = arr[index];

                    arr[index] = entry.getKey();
                    arr[currentIndex] = temp;

                    valueMap.get(temp).remove(Integer.valueOf(index));
                    valueMap.get(temp).add(currentIndex);

                    swapCount++;
                }
            }
            index++;
        }

        return swapCount;
    }

    private static TreeMap<Integer, List<Integer>> getValueMap(final int[] arr) {
        final TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            if (!map.containsKey(value)) {
                final List<Integer> values = new ArrayList<>();
                values.add(i);

                map.put(value, values);
                continue;
            }
            List<Integer> values = map.get(value);
            values.add(i);
        }
        System.out.println(map);
        return map;
    }
}
