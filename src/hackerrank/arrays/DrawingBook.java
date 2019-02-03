package hackerrank.arrays;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class DrawingBook {

    public static void main(String[] args) {
        System.out.println(pageCount(5, 4));
        System.out.println(pageCount(6, 5));
    }

    private static int pageCount(int n, int p) {
        int num1 = p / 2;
        int num2 = (n - p) / 2;

        if (n % 2 == 0 && n - p == 1) {
            num2 = 1;
        }

        return Math.min(num1, num2);
    }
}
