package leetcode.medium;

/**
 * @author Iyanu Adelekan on 26/12/2018.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1,8,6,2,5,4,8,3,7 }));
    }

    private static int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left < right) {
            if (heights[left] > heights[right]) {
                max = Math.max(max, heights[right] * (right - left));
                right--;
            } else {
                max = Math.max(max, heights[left] * (right - left));
                left++;
            }
        }
        return max;
    }
}
