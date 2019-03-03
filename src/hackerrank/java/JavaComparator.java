package hackerrank.java;

import java.util.Comparator;

class JavaComparator {

    class Checker implements Comparator<Player> {

        @Override
        public int compare(Player firstPlayer, Player secondPlayer) {
            if (firstPlayer.score > secondPlayer.score) {
                return -1;
            } else if (firstPlayer.score < secondPlayer.score) {
                return 1;
            }
            return firstPlayer.name.compareTo(secondPlayer.name);
        }
    }

    class Player{
        String name;
        int score;

        Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
}
