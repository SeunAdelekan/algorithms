package hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iyanu Adelekan on 25/12/2018.
 */
public class DynamicArray {

    private static int lastAnswer = 0;
    private static ArrayList<Integer> lastNumbers = new ArrayList<>();

    public static void main(String[] args) {
        final List<List<Integer>> dataSet = new ArrayList<>();

        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(0);
        data.add(5);
        dataSet.add(data);

        List<Integer> data2 = new ArrayList<>();
        data2.add(1);
        data2.add(1);
        data2.add(7);
        dataSet.add(data2);

        List<Integer> data3 = new ArrayList<>();
        data3.add(1);
        data3.add(0);
        data3.add(3);
        dataSet.add(data3);

        List<Integer> data4 = new ArrayList<>();
        data4.add(2);
        data4.add(1);
        data4.add(0);
        dataSet.add(data4);

        List<Integer> data5 = new ArrayList<>();
        data5.add(2);
        data5.add(1);
        data5.add(1);
        dataSet.add(data5);

        dynamicArray(2, dataSet);
    }

    /**
     * Invoked to solve the dynamic array problem.
     *
     * @param n - number of sequences.
     * @param queries - queries.
     * @return
     */
    private static List<Integer> dynamicArray(final int n, final List<List<Integer>> queries) {
        final List<List<Integer>> sequenceList = new ArrayList<>();
        initSequence(n, sequenceList);

        queries.forEach((query) -> {
            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            if (queryType == 1) {
                runFirstQuery(sequenceList, n, x, y);
            } else {
                runSecondQuery(sequenceList, n, x, y);
            }
        });
        return lastNumbers;
    }

    /**
     * Invoked to initialize the provided list with sequences.
     *
     * @param n - number of sequences to be populated.
     * @param sequence - sequence to be populated.
     */
    private static void initSequence(final int n, final List<List<Integer>> sequence) {
        for (int i = 0; i < n; i++) {
            sequence.add(new ArrayList<>());
        }
    }

    /**
     * Invoked to run the first query on a given sequence.
     *
     * @param sequence - sequence.
     * @param x - value x.
     * @param y - value y.
     */
    private static void runFirstQuery(
            final List<List<Integer>> sequence,
            final int n,
            final int x,
            final int y
    ) {
        int index = (x ^ lastAnswer) % n;
        List<Integer> requiredSeq = sequence.get(index);
        requiredSeq.add(y);
    }

    private static void runSecondQuery(
            final List<List<Integer>> sequence,
            final int n,
            final int x,
            final int y
    ) {
        int index = (x ^ lastAnswer) % n;
        List<Integer> requiredSeq = sequence.get(index);

        lastAnswer = requiredSeq.get(y % requiredSeq.size());
        System.out.println(lastAnswer);
        lastNumbers.add(lastAnswer);
    }
}
