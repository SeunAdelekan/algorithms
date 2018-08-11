package hackerrank.arrays;

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    private static void minimumBribes(int[] q) {
        int totalBribes = 0;

        for (int i = 0; i < q.length; i++) {
            int currentValue = q[i];

            // check if person is not in his assigned position.
            if (currentValue > i + 1) {
                // calculating the number of bribes individual made.
                int bribes = currentValue - (i + 1);

                if (bribes > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
                totalBribes += bribes;
            }
        }
        System.out.println(totalBribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
