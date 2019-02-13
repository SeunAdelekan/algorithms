package hackerrank.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Java1DArray {

    private static Set<Integer> visited = new HashSet<>();
    private static Map<Integer, Boolean> outputs = new HashMap<>();

    public static void main(String[] args) {
        int[] game = new int[] { 0, 0, 0, 0, 0 };
        System.out.println(canWin(3, game));

        game = new int[] { 0, 0, 0, 1, 1, 1 };
        System.out.println(canWin(5, game));

        game = new int[] { 0, 0, 1, 1, 1, 0 };
        System.out.println(canWin(3, game));

        game = new int[] { 0, 0 };
        System.out.println(canWin(0, game));

        generateOutput();
        System.out.println(outputs.size());
        solveInputs();
    }

    private static void generateOutput() {
        final File file = new File("output04.txt");
        int count = 0;

        try {
            final Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                outputs.put(++count, scanner.nextLine().trim().equals("YES"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void solveInputs() {
        final File file = new File("input04.txt");

        try {
            final Scanner scanner = new Scanner(file);
            int queries = scanner.nextInt();

            for (int i = 0; i < queries; i++) {
                int n = scanner.nextInt();
                int leap = scanner.nextInt();
                scanner.nextLine();
                String data = scanner.nextLine();

                final Integer[] game = Arrays.stream(data.trim().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
                boolean res = canWin(leap, game);

                if (res != outputs.get(i + 1)) {
                    System.out.println(n);
                    System.out.format("Test fail detected at query %d\nLeap: %d\nQuery: %s\nExpected answer: %s", i + 1, leap, data, outputs.get(i + 1));
                    return;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean canWin(int leap, int[] game) {
        int position = 0;

        if (leap < 0) {
            return false;
        }
        boolean res = solve(position, leap, game);
        visited.clear();

        return res;
    }

    private static boolean canWin(int leap, Integer[] game) {
        int position = 0;

        if (leap < 0) {
            return false;
        }
        boolean res = solve(position, leap, game);
        visited.clear();

        return res;
    }

    private static boolean solve(int position, int leap, int[] game) {
        int position2 = position + 1;
        int position3 = position - 1;
        position += leap;

        if (position >= game.length || position2 >= game.length) {
            return true;
        }  else if (game[position] == 1 && game[position2] == 1 && (position3 < 0 || game[position3] == 1)) {
            return  false;
        }
        boolean res1 = false;
        boolean res2 = false;
        boolean res3 = false;

        if (game[position] == 0 && !visited.contains(position)) {
            visited.add(position);
            res1 = solve(position, leap, game);
        }

        if (game[position2] == 0  && !visited.contains(position2)) {
            visited.add(position2);
            res2 = solve(position2, leap, game);
        }

        if (position3 >= 0 && game[position3] == 0  && !visited.contains(position3)) {
            visited.add(position3);
            res3 = solve(position3, leap, game);
        }

        return res1 || res2 || res3;
    }

    private static boolean solve(int position, int leap, Integer[] game) {
        int position2 = position + 1;
        int position3 = position - 1;
        position += leap;

        if (position >= game.length || position2 >= game.length) {
            return true;
        }  else if (game[position] == 1 && game[position2] == 1 && (position3 < 0 || game[position3] == 1)) {
            return  false;
        }
        boolean res1 = false;
        boolean res2 = false;
        boolean res3 = false;

        if (game[position] == 0 && !visited.contains(position)) {
            visited.add(position);
            res1 = solve(position, leap, game);
        }

        if (game[position2] == 0  && !visited.contains(position2)) {
            visited.add(position2);
            res2 = solve(position2, leap, game);
        }

        if (position3 >= 0 && game[position3] == 0  && !visited.contains(position3)) {
            visited.add(position3);
            res3 = solve(position3, leap, game);
        }

        return res1 || res2 || res3;
    }
}
