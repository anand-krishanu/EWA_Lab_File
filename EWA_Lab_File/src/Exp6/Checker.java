package Exp6;

import java.util.Comparator;

public class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return a.score - b.score;
        }

        int A = (int) a.name.charAt(0);
        int B = (int) a.name.charAt(0);

        return A - B;
    }
}
