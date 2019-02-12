package hackerrank.problemsolving;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class UtopianTree {

    public static void main(String[] args) {
        System.out.println(utopianTree(5));
    }

    private static int utopianTree(int n) {
        int height = 1;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                height *= 2;
            } else {
                height += 1;
            }
        }
        return height;
    }
}
