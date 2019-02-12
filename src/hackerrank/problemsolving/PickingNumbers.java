package hackerrank.problemsolving;

import java.util.*;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class PickingNumbers {

    public static void main(String[] args) {
        System.out.println(pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
        System.out.println(pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2)));
    }

    private static int pickingNumbers(final List<Integer> array) {
        final Map<Integer, Integer> values = generateMap(array);
        final Set<Integer> set = new HashSet<>();
        int maxSize = 0;

        for (Integer data : array) {
            if (set.contains(data)) {
                continue;
            }
            int x = data - 1;
            int y = 1 - data;
            int z = -data;

            if (values.containsKey(x)) {
                maxSize = Math.max(maxSize, values.get(data) + values.get(x));
            }
            if (values.containsKey(y)) {
                maxSize = Math.max(maxSize, values.get(data) + values.get(x));
            }
            if (values.containsKey(z)) {
                maxSize = Math.max(maxSize, values.get(data) + values.get(x));
            }
            maxSize = Math.max(maxSize, values.get(data));

            set.add(data);
        }
        return maxSize;
    }

    private static Map<Integer, Integer> generateMap(final List<Integer> array) {
        final Map<Integer, Integer> map = new HashMap<>();

        array.forEach(e -> {
            if (!map.containsKey(e)) {
                map.put(e, 1);
            } else {
                int count = map.get(e);
                map.put(e, ++count);
            }
        });
        return map;
    }
}
