package hackerrank.problemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iyanu Adelekan on 28/12/2018.
 */
public class GetNodeValue {

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.addNext(2).addNext(3).addNext(4);

        System.out.println(getNode(head, 3));
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        List<SinglyLinkedListNode> list = new ArrayList<>();
        SinglyLinkedListNode current = head;
        list.add(head);

        while (current.next != null) {
            list.add(current.next);
            current = current.next;
        }
        int effectivePosition = list.size() - positionFromTail - 1;
        return list.get(effectivePosition).data;
    }
}
