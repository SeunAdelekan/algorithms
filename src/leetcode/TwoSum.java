package leetcode;

import java.util.*;

/**
 * @author Iyanu Adelekan on 30/08/2018.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] data = new int[] { 3, 2, 4 };
        System.out.println(Arrays.toString(twoSumsTwo(data, 6)));
    }

    private static int[] twoSumsTwo(int[] nums, int target) {
        int index = 0;
        final int[] result = new int[2];
        final HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : nums) {
            int requiredValue = target - number;

            if (map.containsKey(requiredValue)) {
                result[0] = index;
                result[1] = map.get(requiredValue);
                break;
            }
            map.put(number, index);
            index++;
        }

        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        int index = 0;
        int[] result = new int[2];
        final HashMap<Integer, List<Integer>> map = generateValueMap(nums);
        new StringBuilder();
        for (int number : nums) {
            int requiredValue = target - number;

            if (map.containsKey(requiredValue)) {
                List<Integer> indices = map.get(requiredValue);

                for (Integer valueIndex : indices) {
                    if (index != valueIndex) {
                        result[0] = index;
                        result[1] = valueIndex;
                        break;
                    }
                }
            }
            index++;
        }
        return result;
    }

    private static HashMap<Integer, List<Integer>> generateValueMap(final int[] numbers) {
        int index = 0;
        final HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int number : numbers) {
            if (!map.containsKey(number)) {
                List<Integer> values = new ArrayList<>();
                values.add(index);

                map.put(number, values);
            } else if (map.get(number).size() < 2) {
                map.get(number).add(index);
            }
            index++;
        }
        return map;
    }
}
