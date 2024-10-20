package Exp6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparePlayers {
    public static void main(String[] args) {

        List<Player> playerData = new ArrayList<>();
        playerData.add(new Player("Ronaldo", 900));
        playerData.add(new Player("Messi", 838));
        playerData.add(new Player("Lewandoski", 500));
        playerData.add(new Player("Suarez", 500));
        playerData.add(new Player("Halland", 260));

        Checker checker = new Checker();

        Collections.sort(playerData, checker);

        for (Player player: playerData) {
            System.out.println("Name: " + player.name + " Score: " + player.score);
        }
    }
}
