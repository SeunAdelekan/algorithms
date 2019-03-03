package hackerrank.problemsolving;

/**
 * @author Iyanu Adelekan on 03/02/2019.
 */
public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }

    private static int countingValleys(int n, String path) {
        if (path.length() == 0) {
            return 0;
        }
        int level = 0;
        int valleyCount = 0;
        boolean inValley = false;

        for (char c : path.toCharArray()) {
            if (c == 'U') {
                level++;

                if (level >= 0) {
                    inValley = false;
                }
            } else {
                level--;
            }
            if (level < 0 && !inValley) {
                valleyCount++;
                inValley = true;
            }
        }
        return valleyCount;
    }
}
