package Exp7;

import java.util.Queue;
import java.util.Random;

public class RandomGenerator implements Runnable {
    private final Queue<Integer> randomQueue;
    Random random = new Random();

    public RandomGenerator (Queue<Integer> queue) {
        this.randomQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (randomQueue) {
                int randomInt = random.nextInt(100);
                randomQueue.add(randomInt);
                System.out.println("Generated Number: " + randomInt);
                randomQueue.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
