package hackerrank.problemsolving;

/**
 * @author Iyanu Adelekan on 28/12/2018.
 */
class SinglyLinkedListNode {

    protected SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode addNext(int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        this.next = node;
        return node;
    }

    @Override
    public String toString() {
        SinglyLinkedListNode currentNode = this;
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        while (currentNode != null) {
            builder.append(currentNode.data);
            builder.append(", ");

            currentNode = currentNode.next;
        }
        builder.append("]");

        return builder.toString();
    }

    public boolean equals(SinglyLinkedListNode node) {
        return node != null && this.data == node.data;
    }
}