package hackerrank.problemsolving;

/**
 * @author Iyanu Adelekan on 28/12/2018.
 */
public class CompareLinkedLists {

    public static void main(String[] args) {
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        head1.addNext(2).addNext(3).addNext(4);

        SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
        head2.addNext(2).addNext(3).addNext(4);

        System.out.println(compareLists(head1, head2));
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        } else if (head1 == null || head2 == null) {
            return false;
        }

        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;

        while (current1 != null) {
            if (current2 == null) {
                return false;
            }
            if (!current1.equals(current2)) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current2 == null;
    }
}
