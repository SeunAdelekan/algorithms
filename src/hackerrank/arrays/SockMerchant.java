package hackerrank.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class SockMerchant {

    public static void main(String[] args) {
        System.out.println(sockMerchant(9, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 }));
    }

    private static int sockMerchant(int n, int[] array) {
        final Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger matchingPairs = new AtomicInteger();

        Arrays.stream(array).forEach(element -> {
            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                int value = map.get(element);
                map.put(element, ++value);
            }
        });
        map.forEach((key, val) -> matchingPairs.addAndGet(val / 2));

        return matchingPairs.get();
    }
}
