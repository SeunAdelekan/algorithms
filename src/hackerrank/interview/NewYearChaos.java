package hackerrank.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NewYearChaos {

    public static void main(String[] args) {
        minimumBribes(new int[] { 2, 1, 5, 3, 4 });
        minimumBribes(new int[] { 2, 5, 1, 3, 4 });
        solution(new int[] { 2, 1, 5, 3, 4 });
        solution(new int[] { 2, 5, 1, 3, 4 });
    }

    private static void minimumBribes(final int[] array) {
        Map<Integer, Integer> map = generateMap(array);
        Arrays.sort(array);
        int availableSwaps = 0;
        int swapCount = 0;

        for (int i = array.length - 1; i >=0; i--) {
            int currentPosition = map.get(array[i]);

            if (i - currentPosition > 2) {
                printChaotic();
                return;
            } else if (i > currentPosition) {
                availableSwaps += i - currentPosition;
                swapCount += i - currentPosition;
            } else if (i < currentPosition) {
                int swapsNeeded = currentPosition - i;

                if (availableSwaps < swapsNeeded) {
                    printChaotic();
                    return;
                }
                availableSwaps -= swapsNeeded;
            }
        }

        if (availableSwaps != 0) {
            printChaotic();
        } else {
            System.out.println(swapCount);
        }
    }

    private static void solution(final int[] array) {
        int ans = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, array[i] - 2); j < i; j++) {
                if (array[j] > array[i]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void printChaotic() {
        System.out.println("Too chaotic");
    }

    private static Map<Integer, Integer> generateMap(final int[] array) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        return map;
    }
}
