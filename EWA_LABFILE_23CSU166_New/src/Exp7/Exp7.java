package Exp7;

import java.util.LinkedList;
import java.util.Queue;

public class Exp7 {
    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList<>();

        RandomGenerator randomGenerator = new RandomGenerator(sharedQueue);
        ConditionalNumber conditionalNumber = new ConditionalNumber(sharedQueue);

        Thread t1 = new Thread(randomGenerator);
        Thread t2 = new Thread(conditionalNumber);

        t1.start();
        t2.start();
    }
}
