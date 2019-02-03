package hackerrank.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class BonAppetit {

    public static void main(String[] args) {
        bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12);
        bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 7);
    }

    private static void bonAppetit(List<Integer> bill, int k, int b) {
        int total = 0;
        int fairContribution;

        for (int i = 0; i < bill.size(); i++) {
            if (!(i == k)) {
                total += bill.get(i);
            }
        }
        fairContribution = total / 2;

        if (b == fairContribution) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - fairContribution);
        }
    }
}
