package structures;

public class SinglyLinkedListNode {

    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public SinglyLinkedListNode setData(final int data) {
        this.data = data;
        return this;
    }

    public SinglyLinkedListNode setNext(final SinglyLinkedListNode node) {
        this.next = node;
        return this;
    }
}
