package hackerrank.arrays;

import java.util.*;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class MigratoryBirds {

    public static void main(String[] args) {
        System.out.println(migratoryBirds(Arrays.asList(1, 4, 4, 4, 5, 3)));
        System.out.println(migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }

    private static int migratoryBirds(final List<Integer> data) {
        final Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (Integer aData : data) {
            int birdType = aData;

            if (!map.containsKey(birdType)) {
                map.put(birdType, 1);

                if (result == 0) {
                    result = birdType;
                }
            } else {
                int occurrences = map.get(birdType);
                map.put(birdType, ++occurrences);
            }

            int current = map.get(birdType);
            int currentMax = map.get(result);

            if (current > currentMax) {
                result = birdType;
            }
            if (current == currentMax && birdType < result) {
                result = birdType;
            }
        }
        return result;
    }
}
