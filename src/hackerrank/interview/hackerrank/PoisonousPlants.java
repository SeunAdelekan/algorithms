package hackerrank.interview.hackerrank;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author Iyanu Adelekan on 21/08/2018.
 */
public class PoisonousPlants {

    public static void main(String[] args) {
        System.out.println(poisonousPlants(new int[] { 6, 5, 8, 4, 7, 10, 9 }));
    }

    private static int poisonousPlants(final int[] arr) {
        int day = 0;
        boolean deathsPossible = true;
        final HashSet<Integer> indices = new HashSet<>();
        final List<Integer> plants = Arrays.stream(arr).boxed().collect(Collectors.toList());

        while (deathsPossible) {
            for (int i = 1; i < plants.size(); i++) {
                if (plants.get(i) > plants.get(i - 1)) {
                    indices.add(i);
                }
            }

            if (indices.size() != 0) {
                AtomicInteger deletions = new AtomicInteger(0);

                indices.forEach(index -> {
                    plants.remove(index - deletions.get());
                    deletions.set(deletions.get() + 1);
                });
                indices.clear();
                day++;

                continue;
            }
            deathsPossible = false;
        }
        return day;
    }
}
