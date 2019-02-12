package hackerrank.DS;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAndSimpleQueries {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        final int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int type = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (type == 1) {
                executeQuery1(data, x, y);
                continue;
            }
            executeQuery2(data, x, y);
        }
        scanner.close();
        System.out.println(data[0] - data[data.length - 1]);
        System.out.println(Arrays.toString(data));
    }

    private static int[] executeQuery1(int[] data, int x, int y) {
        final int[] result = new int[data.length];
        int position = 0;

        for (int i = x - 1; i < y; i++, position++) {
            result[position] = data[i];
        }

        for (int i = 0; i < x - 1; i++, position++) {
            result[position] = data[i];
        }

        for (int i = y; i < data.length; i++, position++) {
            result[position] = data[i];
        }

        data = result;
        return data;
    }

    private static int[] executeQuery2(int data[], int x, int y) {
        final int[] result = new int[data.length];
        int position = 0;

        for (int i = 0; i < x - 1; i++, position++) {
            result[position] = data[i];
        }

        for (int i = y; i < data.length; i++, position++) {
            result[position] = data[i];
        }

        for (int i = x - 1; i < y; i++, position++) {
            result[position] = data[i];
        }

        data = result;
        return data;
    }
}
