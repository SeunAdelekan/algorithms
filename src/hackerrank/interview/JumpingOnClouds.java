package hackerrank.interview;

public class JumpingOnClouds {

    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 0 }));
    }

    public static int jumpingOnClouds(final int[] array) {
        int jumps = 0;

        for (int i = 0; i < array.length - 1;) {
            i += (i + 2 < array.length && array[i + 2] == 0) ? 2 : 1;
            jumps++;
        }
        return jumps;
    }
}
