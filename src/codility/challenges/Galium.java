package codility.challenges;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO Finish up solution.
 */
public class Galium {

    public static void main(String[] args) {
        generateCombinations();
    }

    private static void solution(int[] a, int n) {

    }

    private static void generateCombinations() {
        List<List<Integer>> powerSet = new LinkedList<>();
        List<Integer> dataSet = IntStream.rangeClosed(1, 500).boxed().collect(Collectors.toList());
        powerSet.addAll(combination(dataSet, 3));

        System.out.println(powerSet);
    }

    private static <T> List<List<T>> combination(List<T> values, int size) {

        if (0 == size) {
            return Collections.singletonList(Collections.<T>emptyList());
        }

        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<T>> combination = new LinkedList<>();

        T actual = values.iterator().next();

        List<T> subSet = new LinkedList<>(values);
        subSet.remove(actual);

        List<List<T>> subSetCombination = combination(subSet, size - 1);

        for (List<T> set : subSetCombination) {
            List<T> newSet = new LinkedList<>(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }

        combination.addAll(combination(subSet, size));

        return combination;
    }
}
