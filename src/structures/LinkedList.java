package structures;

/**
 * @author Iyanu Adelekan on 20/08/2018.
 */
public class LinkedList<T> {

    private int size = 0;
    private Node<T> root = null;
    private Node<T> tail = null;

    public boolean add(T value) {
        Node<T> node = new Node<>(value);

        if (root == null) {
            root = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
        return true;
    }

    public T get(final int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException(String.format("The index %d is out of bounds.", index));
        } else if (index == size - 1) {
            return tail.getValue();
        } else {
            Node<T> current = null;

            for (int i = 0; i <= index; i++) {
                if (i == 0) {
                    current = root;
                    continue;
                }
                current = current.next;
            }
            return current.getValue();
        }
    }

    public void remove(final int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException(String.format("The index %d is out of bounds.", index));
        } else if (index == size - 1) {
            tail.getPrevious().setNext(null);
        } else {
            Node<T> current = root;

            for (int i = 0; i < index; i++) {
                current = current.next;
                current.getPrevious().setNext(current.next);

                if (current.next != null) {
                    current.next.setPrevious(current.getPrevious());
                }
            }
        }
    }

    public int size() {
        return size;
    }

    private class Node<U> {

        Node(U value) {
            this.value = value;
        }

        private U value;
        private Node<U> next;
        private Node<U> previous;

        void setNext(final Node<U> node) {
            next = node;

            if (node != null) {
                node.setPrevious(this);
            }
        }

        Node<U> getNext() {
            return next;
        }

        void setPrevious(final Node<U> node) {
            previous = node;
        }

        Node<U> getPrevious() {
            return previous;
        }

        U getValue() {
            return value;
        }
    }
}
