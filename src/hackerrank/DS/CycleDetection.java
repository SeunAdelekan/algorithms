package hackerrank.DS;

import structures.SinglyLinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {

    public static void main(String[] args) {
        final SinglyLinkedListNode root1 = null;
        final SinglyLinkedListNode root2 = new SinglyLinkedListNode(1);
        final SinglyLinkedListNode root3 = new SinglyLinkedListNode(23);

        root3.setNext(new SinglyLinkedListNode(67).setNext(root3));

        System.out.println(hasCycle(root1));
        System.out.println(hasCycle(root2));
        System.out.println(hasCycle(root3));
    }

    private static boolean hasCycle(final SinglyLinkedListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        final Set<SinglyLinkedListNode> set = new HashSet<>();
        SinglyLinkedListNode currentNode = node;
        set.add(currentNode);

        while (currentNode.next != null) {
            currentNode = currentNode.next;

            if (set.contains(currentNode)) {
                return true;
            }
            set.add(currentNode);
        }
        return false;
    }
}
