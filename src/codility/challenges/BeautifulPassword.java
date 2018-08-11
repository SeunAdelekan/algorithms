package codility.challenges;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Iyanu Adelekan on 24/06/2018.
 */
public class BeautifulPassword {

    private static int longestPassword = 0;

    public static void main(String[] args) {
        long start, end;
        long sum = 0;
        start = System.currentTimeMillis();
        for (long i = 0; i < 10000000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        System.out.println(LongStream.range(0, 10000000000000L).sum());
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static int solution(String password) {
        for (int i : IntStream.range(0, 2).toArray()) {

        }
        return longestPassword;
    }

    private static void divide(String str, int start, int end) {

    }
}
