package leetcode.medium;

import java.util.*;

/**
 * @author Iyanu Adelekan on 26/12/2018.
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    private static List<List<Integer>> threeSum(final int[] numbers) {
        final List<List<Integer>> result = new ArrayList<>();
        final Set<List<Integer>> resultSet = new HashSet<>();
        final Map<Integer, List<Integer>> valueMap = generateMap(numbers);
        int a, b, sum, c;

        for (int i = 0; i < numbers.length; i++) {
            a = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                b = numbers[j];
                sum = a + b;
                c = sum == 0 ? 0 : -sum;

                if (valueMap.containsKey(c)) {
                    List<Integer> indices = valueMap.get(c);

                    for (int k = 0; k < indices.size(); k++) {
                        if (indices.get(k) > i && indices.get(k) > j) {

                            List<Integer> list = new ArrayList<>();
                            list.add(a);
                            list.add(b);
                            list.add(c);
                            Collections.sort(list);

                            if (!resultSet.contains(list)) {
                                result.add(list);
                                resultSet.add(list);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static Map<Integer, List<Integer>> generateMap(final int[] numbers) {
        final Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);

                map.put(numbers[i], list);
                continue;
            }
            List<Integer> list = map.get(numbers[i]);
            list.add(i);
        }
        return map;
    }
}
