package hackerrank.problemsolving;

import java.math.BigInteger;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class ExtraLongFactorials {

    public static void main(String[] args) {
        extraLongFactorials(2);
    }

    private static void extraLongFactorials(int n) {
        BigInteger val = new BigInteger(String.valueOf(n));

        System.out.println(extraLongFactorials(val));
    }

    private static BigInteger extraLongFactorials(final BigInteger n) {
        BigInteger one = new BigInteger("1");

        if (n.equals(one)) {
            return one;
        }
        return n.multiply(extraLongFactorials(n.subtract(one)));
    }
}
