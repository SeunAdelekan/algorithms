package hackerrank.java;

/**
 * @author Iyanu Adelekan on 12/02/2019.
 */
public class LambdaExpressions {

    interface PerformOperation {
        boolean check(int a);

    }

    class MyMath {
        public boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        PerformOperation isOdd() {
            return number -> number % 2 == 1;
        }

        PerformOperation isPrime() {
            return number -> {
                for (int i = 2; i ++< (Math.sqrt(number)) + 1;) {
                    if  (number % i == 0) {
                        return false;
                    }
                }
                return true;
            };
        }

        PerformOperation isPalindrome() {
            return number -> {
                String str = String.valueOf(number);

                if (str.length() == 1) {
                    return true;
                }

                for (int i = 0, j = str.length() - 1; i <= str.length() / 2; i++, j--) {
                    if (str.charAt(i) != str.charAt(j)) {
                        return false;
                    }
                }
                return true;
            };
        }
    }
}
