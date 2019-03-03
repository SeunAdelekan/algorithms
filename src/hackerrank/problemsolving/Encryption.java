package hackerrank.problemsolving;

import java.util.Arrays;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class Encryption {

    public static void main(String[] args) {
        System.out.println(encryption("if man was meant to stay on the ground god would have given us roots"));
        System.out.println(encryption("haveaniceday"));
        System.out.println(encryption("feedthedog"));
        System.out.println(encryption("chillout"));
    }

    private static String encryption(final String s) {
        final String input = strip(s);
        int rows;
        double root = Math.sqrt(s.length());

        if (Math.ceil(root) - root <= 0.5) {
            rows = (int) Math.ceil(root);
        } else {
            rows = (int) Math.floor(Math.sqrt(s.length()));
        }
        int columns = (int) Math.ceil(Math.sqrt(s.length()));
        final char[][] encryptionMatrix = new char[rows][columns];

        int row = 0;
        int column = 0;

        for (int i = 0; i < input.length(); i++) {
            encryptionMatrix[row][column] = input.charAt(i);
            column++;

            if (column == columns) {
                row++;
                column = 0;
            }
            if (row == rows) {
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            System.out.println(encryptionMatrix[i]);
        }
        return generateEncryptedString(encryptionMatrix, rows, columns);
    }

    private static String generateEncryptedString(final char[][] array, int rows, int columns) {
        final StringBuilder builder = new StringBuilder();

        int row = 0;
        int column = 0;

        while (row < rows) {
            if (!(array[row][column] == '\u0000')) {
                builder.append(array[row][column]);
            }
            row++;

            if (row == rows && column < columns - 1) {
                row = 0;
                column++;
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private static String strip(final String s) {
        final StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
