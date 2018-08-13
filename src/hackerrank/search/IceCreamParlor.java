package hackerrank.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Iyanu Adelekan on 12/08/2018.
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        whatFlavours(new int[] { 4, 3, 2, 5, 7 }, 8);
    }

    private static void whatFlavours(final int[] costs, final int money) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int index = 1;

        for (int i : costs) {
            if (!map.containsKey(i)) {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(index);
                map.put(i, indexList);
                index++;
                continue;
            }
            map.get(i).add(index);
            index++;
        }
        System.out.println(map);
        for (int cost : costs) {
            int neededCost = money - cost;

            if (map.containsKey(neededCost)) {
                int firstPosition;
                int secondPosition;
                List<Integer> neededCostPositions = map.get(neededCost);

                if (neededCost == cost && neededCostPositions.size() > 1) {
                    firstPosition = neededCostPositions.get(0);
                    secondPosition = neededCostPositions.get(1);

                    System.out.printf("%d %d\n", firstPosition, secondPosition);
                } else if (map.get(cost).get(0) > neededCostPositions.get(0)) {
                    firstPosition = neededCostPositions.get(0);
                    secondPosition = map.get(cost).get(0);

                    System.out.printf("%d %d\n", firstPosition, secondPosition);
                } else if (map.get(cost).get(0) < neededCostPositions.get(0)) {
                    firstPosition = map.get(cost).get(0);
                    secondPosition = neededCostPositions.get(0);

                    System.out.printf("%d %d\n", firstPosition, secondPosition);
                }
                return;
            }
        }
    }
}
