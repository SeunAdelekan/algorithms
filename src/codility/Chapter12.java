package codility;

/**
 * @author Iyanu Adelekan on 11/08/2018.
 *
 * This Chapter is on the Euclidean algorithm.
 */
public class Chapter12 {

    public static void main(String[] args) {
        System.out.println(gcdBySubtraction(10, 7));
        System.out.println(gcdByDivision(12, 3));

        System.out.println(lcm(12, 3));
        System.out.println(lcm(12, 3, 15));
    }

    /**
     * Prints an upside down symmetric triangle.
     * Worst case time complexity: O(m * n).
     *
     * Reason:
     * Complexity = O(m) * [O(i) + o(j)]
     * = O(m) * O(j)
     * = O(m * j)
     *
     * @param n - the number of rows contained in the triangle.
     */
    private static void invertedTriangle(final int n){
        int m;
        int step = 1;
        int subtractable = 1;

        while ((m = 2 * n - subtractable) >= 1) {
            for (int i = 0; i < step; i++) {
                System.out.print(" ");
            }
            for (int j = 0; j < m; j++) {
                System.out.print("*");
            }
            System.out.println();
            subtractable += 2;
            step++;
        }
    }

    /**
     * Computes the greatest common divisor of two positive numbers.
     * Worst case time complexity: O(n).
     *
     * Reason: The number of steps in the algorithm is linear.
     *
     * @param a - first number.
     * @param b - second number.
     * @return int - GCD
     */
    private static int gcdBySubtraction(final int a, final int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcdBySubtraction(a - b, b);
        } else {
            return gcdBySubtraction(a, b - a);
        }
    }

    /**
     * Computes the GCD of two numbers.
     *
     * @see Chapter12#gcdBySubtraction(int, int) for information
     * pertaining to runtime complexity.
     *
     * @param a - first number.
     * @param b - second number.
     * @return int
     */
    private static int gcdByDivision(final int a, final int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcdByDivision(b, a % b);
        }
    }

    /**
     * Calculates the LCM of two numbers.
     * Worst case time complexity: O(n).
     *
     * Reason: The numerator is estimated in constant time O(1)
     * but the denominator in O(n) time. Hence the worst case
     * time complexity is dependent on the denominator.
     *
     * @param a - the first number.
     * @param b - the second number.
     * @return int - the LCM
     */
    private static int lcm(final int a, final int b) {
        return (a * b) / gcdByDivision(a, b);
    }

    /**
     * Finds the LCM of three numbers.
     *
     * @param a - first number.
     * @param b - second number.
     * @param c - third number.
     * @return - the LCM.
     */
    private static int lcm(final int a, final int b, final int c) {
        return lcm(a, lcm(b, c));
    }
}
