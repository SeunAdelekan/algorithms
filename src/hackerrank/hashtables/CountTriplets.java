package hackerrank.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Iyanu Adelekan on 12/08/2018.
 */
public class CountTriplets {

    public static void main(String[] args) {
        final Long[] values = new Long[]{ 1L, 3L, 9L, 9L, 27L, 81L };
        final Long[] dataSet = new Long[100];
        Arrays.fill(dataSet, 1L);

        List<Long> list = new ArrayList<>(Stream.of(dataSet).collect(Collectors.toList()));

        System.out.println(countTriplets(list, 1));
    }

    /**
     * TODO Debug code.
     *
     * @param arr
     * @param r
     * @return
     */
    private static long countTriplets(final List<Long> arr, final long r) {
        // create a hash containing all the elements in the list.
        HashMap<Long, Integer> map = new HashMap<>();

        IntStream.range(0, arr.size()).forEach(index -> {
            long key = arr.get(index);

            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        });
        AtomicInteger count = new AtomicInteger(0);

        // Discover triplets in the list.
        arr.forEach(e -> {
            if (e != 0) {
                map.put(e, map.get(e) - 1);
                long second = calculateNext(e, r, 2);
                long third = calculateNext(e, r, 3);

                if (map.containsKey(second) && map.containsKey(third)) {
                    // Calculate the value of occurrences of second and third elements.
                    int times = map.get(second) * map.get(third);

                    count.set(count.get() + times); // Triplet found hence count increased.
                }
            }
        });
        return (long) count.get();
    }

    private static long calculateNext(final long a, final long r, final int n) {
        return (long) (a * Math.pow(r, n - 1));
    }
}
