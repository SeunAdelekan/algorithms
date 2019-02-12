package hackerrank.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Iyanu Adelekan on 04/02/2019.
 */
public class BigDecimalQuestion {

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];

        for (int i=0;i<n;i++) {
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, Collections.reverseOrder((a, b) -> {
            if (a == null) {
                return 0;
            }
            BigDecimal val1 = new BigDecimal(a);
            BigDecimal val2 = new BigDecimal(b);

            return val1.compareTo(val2);
        }));
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
