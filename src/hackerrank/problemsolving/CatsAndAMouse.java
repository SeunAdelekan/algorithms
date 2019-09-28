package hackerrank.problemsolving;

public class CatsAndAMouse {

    public static void main(String[] args) {
        System.out.println(catAndMouse(1, 2, 3));
        System.out.println(catAndMouse(1, 3, 2));
    }

    private static String catAndMouse(final int x, final int y, final int z) {
        String output;
        int firstDistance = Math.abs(z - x);
        int secondDistance = Math.abs(z - y);

        if (firstDistance > secondDistance) {
            output = "Cat B";
        } else if (firstDistance < secondDistance) {
            output = "Cat A";
        } else {
            output = "Mouse C";
        }
        return output;
    }
}
