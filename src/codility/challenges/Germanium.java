package codility.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Todo Finish up solution.
 */
public class Germanium {

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1, 4 }, new int[] { 4, 5 }, 2));
    }

    private static int solution(int[] A, int[] B, int n) {
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashSet<Integer> setA = new HashSet<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        /*
         * Storing values into Maps and sets to facilitate
         * rapid retrievals.
         */
        for (int i = 0; i < A.length; i++) {
            mapA.put(i, A[i]);
            setA.add(A[i]);
            mapB.put(i, B[i]);
        }
        System.out.println(mapA);
        System.out.println(setA);
        System.out.println(mapB);
        /*
         * Flipping cards.
         */
        for (int i = 0; i < A.length; i++) {
            if ( mapA.get(i) > mapB.get(i)) {
                int temp = mapA.get(i);

                mapA.put(i, mapB.get(i));
                mapB.put(i, temp);
            }
        }

        /*
         * Sorting values of cards in set A.
         */
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(mapA.entrySet());
        System.out.println(entries);

        entries.sort((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return 1;
            } else if (o1.getValue() < o2.getValue()) {
                return -1;
            }
            return 0;
        });
        System.out.println(entries);
        AtomicInteger lowerBound = new AtomicInteger(-1);
        AtomicInteger maxScore = new AtomicInteger(-1);

        IntStream.range(0, entries.size() - 1)
                .forEach(index -> {
                    if (index == 0) {
                        lowerBound.set(entries.get(index).getValue());
                    } else {
                        HashMap.Entry<Integer, Integer> entry = entries.get(index);

                        if (entry.getValue() - lowerBound.get() > 1) {
                            System.out.println(true);
                            System.out.println(entry.getValue());
                            System.out.println(lowerBound.get());
                            maxScore.set(entries.get(index).getValue() - 1);
                        }
                        lowerBound.set(lowerBound.get() + 1);
                    }
                });
        int result;

        if (lowerBound.get() == entries.get(0).getValue() && lowerBound.get() > 1) {
            result = entries.get(0).getValue() - 1;
        } else if (maxScore.get() == -1) {
            result = entries.get(entries.size() - 1).getValue() + 1;
        } else {
            result = maxScore.get();
        }
        return result;
    }
}
