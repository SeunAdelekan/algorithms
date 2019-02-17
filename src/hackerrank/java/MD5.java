package hackerrank.java;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.security.MessageDigest;

/**
 * @author Iyanu Adelekan on 13/02/2019.
 */
public class MD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        final Scanner scanner = new Scanner(System.in);
        final String str = scanner.nextLine();
        final MessageDigest digest = MessageDigest.getInstance("MD5");
        final StringBuilder buffer = new StringBuilder();
        scanner.close();

        final byte[] bytes = digest.digest(str.getBytes());

        for (byte val : bytes) {
            buffer.append(Integer.toHexString((val & 0xFF) | 0x100).substring(1, 3));
        }

        System.out.println(buffer.toString());
    }
}
