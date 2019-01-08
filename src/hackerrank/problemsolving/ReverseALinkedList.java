package hackerrank.problemsolving;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Iyanu Adelekan on 28/12/2018.
 */
public class ReverseALinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.addNext(2).addNext(3).addNext(4);
        System.out.println(head);
//        reverse(head);
        System.out.println(reverse(head));
    }

    private static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        final List<SinglyLinkedListNode> list = new ArrayList<>();

        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedListNode currentNode = head;

        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i != 0) {
                list.get(i).next = list.get(i - 1);
            } else {
                list.get(i).next = null;
            }
        }

        return list.get(list.size() - 1);
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
            int count = 0;
            while (currentNode != null) {
//                System.out.println(count);
                builder.append(currentNode.data);
                builder.append(", ");

                currentNode = currentNode.next;
                count++;
            }
            builder.append("]");

            return builder.toString();
        }
    }
}
