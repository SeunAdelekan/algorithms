package cracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Iyanu Adelekan on 19/08/2018.
 */
public class Chapter2 {

    public static void main(String[] args) {
        final LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        System.out.println(removeDups(list));
    }

    /**
     * Removes duplicate values from a linked list.
     * Worst case time complexity: O(n).
     *
     * Note: Always take into consideration to resizing of lists
     * once you remove values from them. If you remove a value from
     * index 0 the `next` element to be checked will now be at index 0.
     * Thus don't increase the counter.
     *
     * @param list - list to work on.
     * @param <T> - type of values held in the list.
     */
    private static <T> LinkedList<T> removeDups(final LinkedList<T> list) {
        final HashSet<T> set = new HashSet<>();

        for (int i = 0; i < list.size();) {
            T next = list.get(i);

            if (!set.contains(next)) {
                set.add(next);
                i++;
                continue;
            }
            list.remove(i);
        }
        return list;
    }
}
