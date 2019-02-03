package hackerrank.problemsolving;

import java.util.*;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class ClimbingTheLeaderboard {

    public static void main(String[] args) {
        int[] scores = new int[] { 50, 50, 60, 50, 90, 10, 100 };
        int[] alice = new int[] { 1, 1000, 85 };

        System.out.println(Arrays.toString(climbingLeaderboard(scores, alice)));
        System.out.println(Arrays.toString(climbingLeaderboard(
                new int[] { 100, 100, 50, 40, 40, 20, 10 },
                new int[] { 5, 25, 50, 120 })));
    }

    /**
     * Worst case time complexity: O (n * m)
     * TODO Figure out how to reduce this runtime.
     *
     * @param scores - class scores.
     * @param alice - alice's scores.
     * @return array - alice's positions.
     */
    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        final Map<Integer, Integer> map = buildLeaderboard(scores);
        final int[] positions = new int[alice.length];


        for (int i = 0; i < alice.length; i++) {
            int score = alice[i];
            int index = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (score >= entry.getValue()) {
                    positions[i] = entry.getKey();
                    break;
                }
                if (index == map.size() - 1) {
                    positions[i] = entry.getKey() + 1;
                }
                index++;
            }
        }
        return positions;
    }

    private static Map<Integer, Integer> buildLeaderboard(int[] scores) {
        final Map<Integer, Integer> board = new TreeMap<>();
        Arrays.sort(scores);
        int position = 0;
        int previous = 0;

        for (int i = scores.length - 1; i >= 0; i--) {
            if (board.size() == 0) {
                position = 1;
                board.put(position, scores[i]);

                previous = scores[i];
                continue;
            }

            if (previous != scores[i]) {
                position++;
            }
            board.put(position, scores[i]);
            previous = scores[i];
        }
        return board;
    }
}
