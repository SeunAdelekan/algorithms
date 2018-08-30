package random.bitmanipulation;

/**
 * @author Iyanu Adelekan on 30/08/2018.
 */
public class DifferingBits {

    public static void main(String[] args) {
        System.out.println(findBitCount(10, 2));
    }

    private static int findBitCount(int a, int b) {
        int z = a ^ b;
        int bitCount = 0;

        while (z != 0) {
            bitCount += z & 1;
            z = z >> 1;
        }
        return bitCount;
    }
}
