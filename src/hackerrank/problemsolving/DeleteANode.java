package hackerrank.problemsolving;

/**
 * @author Iyanu Adelekan on 28/12/2018.
 */
public class DeleteANode {

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.addNext(2).addNext(3).addNext(4);

        System.out.println(head);
        System.out.println(deleteNode(head, 0));
    }

    private static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 0) {
            head = head.next;
            return head;
        }
        int index = 1;
        SinglyLinkedListNode current = head;

        while (index < position) {
            current = current.next;
            index++;
        }
        if (current.next.next != null) {
            current.next = current.next.next;
        } else {
            current.next = null;
        }
        return head;
    }

    private static class SinglyLinkedListNode {

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }

        private int data;
        private SinglyLinkedListNode next;

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
    }
}
