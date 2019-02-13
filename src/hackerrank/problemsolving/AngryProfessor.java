package hackerrank.problemsolving;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class AngryProfessor {

    public static void main(String[] args) {
        System.out.println(angryProfessor(3, new int[] { -1, -3, 4, 2 }));
        System.out.println(angryProfessor(2, new int[] { 0, -1, 2, 1 }));
    }

    /**
     * Worst case time complexity: O(n).
     *
     * @param k - cancellation threshold.
     * @param array - arrival times.
     * @return String - YES if cancelled and NO otherwise.
     */
    private static String angryProfessor(int k, final int[] array) {
        int count = 0;

        for (int time : array) {
            if (time <= 0) {
                count++;
            }
        }
        return count >= k ? "NO" : "YES";
    }
}
