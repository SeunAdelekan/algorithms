package hackerrank.trees;

public class CheckBST {

    public static void main(String[] args) {
        final Node<Integer> root = new Node<>(3);

        root.left = (new Node<>(2))
                .setLeft(new Node<>(1));

        root.right = (new Node<>(7))
                .setLeft(new Node<>(6)
                .setRight(new Node<>(8)));

        System.out.println(checkBST(root));
    }

    private static <T extends Number> boolean checkBST(final Node<T> root) {
        if (root.left != null && root.left.value.intValue() >= root.value.intValue()) {
            return false;
        } else if (root.right != null && root.right.value.intValue() <= root.value.intValue()) {
            return false;
        }

        if (root.right != null && root.left != null) {
            return checkBST(root.left) && checkBST(root.right);
        } else if (root.right != null) {
            return checkBST(root.right);
        } else if (root.left != null) {
            return checkBST(root.left);
        } else {
            return true;
        }
    }

    private static class Node<T extends Number> {

        Node(final T value) {
            this.value = value;
            left = null;
            right = null;
        }

        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node<T> setLeft(Node<T> node) {
            left = node;
            return this;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> setRight(Node<T> node) {
            right = node;
            return this;
        }

        public Node<T> getRight() {
            return right;
        }

        private T getValue() {
            return value;
        }
    }
}
