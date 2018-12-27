package leetcode.medium;

import java.math.BigInteger;

/**
 * @author Iyanu Adelekan on 30/08/2018.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        final ListNode a = new ListNode(9);
        a.addNext(9).addNext(9).addNext(9).addNext(9);

        final ListNode b = new ListNode(1);

        System.out.println(addTwoNumbers(a, b));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger a = getIntegerValue(l1);
        BigInteger b = getIntegerValue(l2);
        BigInteger c = a.add(b);

        return getListRepresentation(c);
    }

    private static BigInteger getIntegerValue(ListNode node) {
        final StringBuilder builder = new StringBuilder();

        while (node != null) {
            builder.insert(0, node.val);
            node = node.next;
        }

        return new BigInteger(builder.toString());
    }

    private static ListNode getListRepresentation(final BigInteger num) {
        String value = new StringBuilder(num.toString()).reverse().toString();
        final ListNode root = new ListNode(charToInt(value.charAt(0)));
        ListNode currentNode = root;

        for (int i = 1; i < value.length(); i++) {
            ListNode node = new ListNode(charToInt(value.charAt(i)));

            if (currentNode != null) {
                currentNode.next = node;
            }
            currentNode = node;
        }

        return root;
    }

    private static int charToInt(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    private static class ListNode {

        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
        }

        ListNode addNext(int value) {
            next = new ListNode(value);
            return next;
        }

        @Override
        public String toString() {
            ListNode currentNode = this;
            final StringBuilder builder = new StringBuilder();

            builder.append("[");
            while (currentNode != null) {
                builder.append(currentNode.val);

                if (currentNode.next != null) {
                    builder.append(",");
                }

                currentNode = currentNode.next;
            }
            builder.append("]");

            return builder.toString();
        }
    }
}
