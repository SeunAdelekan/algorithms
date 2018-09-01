package random.bitmanipulation;

/**
 * @author Iyanu Adelekan on 01/09/2018.
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{ 1, 1, 1, 3, 3, 3, 10, 4, 4, 4 }));
    }

    private static int singleNumber(final int[] numbers) {
        int mask1 = 0, mask2 = 0;

        for (int number : numbers) {
            mask2 ^= mask1 & number;
            mask1 ^= number;

            int mask = ~(mask1 & mask2);
            mask2 &= mask;
            mask1 &= mask;
        }
        return mask1;
    }
}
