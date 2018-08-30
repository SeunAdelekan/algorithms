package hackerrank.interview;

/**
 * @author Iyanu Adelekan on 29/08/2018.
 */
public class DumpNode {

    public static void main(String[] args) {
        final Node root = new Node(4);

        root.left = new Node(5);
        root.right = new Node(6);

        System.out.println(dump(root));
    }

    private static String dump(final Node node) {
        if (node == null) {
            return "";
        } else if (node.left == null && node.right == null) {
            return String.valueOf(node.value);
        } else if (node.left != null && node.right != null) {
            return String.format("%d %d %d", node.value, node.left.value, node.right.value);
        }
        return "";
    }

    static private class Node {

        Node(int value) {
            this.value = value;
        }

        private int value;
        private Node left;
        private Node right;
    }
}
