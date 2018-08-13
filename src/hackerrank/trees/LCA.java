package hackerrank.trees;

/**
 * My solution to the lowest common ancestor problem
 * on HackerRank within the interview preparation toolkit.
 */
public class LCA {

    public static void main(String[] args) {
        final Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(4);

        System.out.println(lca(root, 1, 4).data);
    }

    private static Node lca(final Node root, final int v1, final int v2) {
        if ((v1 < root.data && v2 > root.data) || (v2 < root.data && v1 > root.data)) {
            return root;
        } else if (root.data == v1 || root.data == v2) {
            // The root is returned if it has the same value as either element.
            return root;
        } else if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        } else {
            return lca(root.left, v1, v2);
        }
    }

    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
