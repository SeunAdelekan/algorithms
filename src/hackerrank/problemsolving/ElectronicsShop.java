package hackerrank.problemsolving;

public class ElectronicsShop {

    public static void main(String[] args) {
        System.out.print(getMoneySpent(new int[] { 3, 1}, new int[] { 5, 2, 8 }, 5));
    }

    /**
     * Calculates the max amount spendable on USB drive and keyboard within budget.
     * Returns -1 if no such amount exists.
     * @param keyboards - array of keyboard prices.
     * @param drives - array of USB drive prices.
     * @param b - budget amount.
     * @return max price spendable.
     */
    private static int getMoneySpent(final int[] keyboards, final int[] drives, final int b) {
        int maxAmount = Integer.MIN_VALUE;

        for (int i : keyboards) {
            for (int j : drives) {
                if (i + j <= b) {
                    maxAmount = Math.max(maxAmount, i + j);
                }
            }
        }
        return maxAmount != Integer.MIN_VALUE ? maxAmount : -1;
    }
}
