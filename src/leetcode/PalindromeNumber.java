package leetcode;

/**
 * @author Iyanu Adelekan on 25/12/2018.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(22));
        System.out.println(isPalindrome(223));
        System.out.println(isPalindrome(232));
        System.out.println(isPalindrome(-23));
    }

    /**
     * Solution to the PalindromeNumber problem.
     *
     * @param x - number to be tested.
     * @return boolean - true if number is a palindrome and false otherwise.
     */
    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        String value = String.valueOf(x);

        for (int i = 0, j = value.length() - 1; i < value.length() / 2; i++, j--) {
            if (value.charAt(i) != value.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
