package honeypot;

import java.util.Arrays;
import java.util.List;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class BinaryNumbers {

    public static void main(String[] args) {
        System.out.println(rearrange(Arrays.asList(1, 2, 3)));
    }

    private static List<Integer> rearrange(List<Integer> elements) {
        elements.sort((a, b) -> {
            Integer num1 = countOnes(Integer.toBinaryString(a));
            Integer num2 = countOnes(Integer.toBinaryString(b));

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }

            return a.compareTo(b);
        });
        return elements;
    }

    private static int countOnes(String binary) {
        int count = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
