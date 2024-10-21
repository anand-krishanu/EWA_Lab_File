package Exp7;

import java.util.Queue;

public class ConditionalNumber implements Runnable{
    private final Queue<Integer> generateQueue;

    public ConditionalNumber(Queue<Integer> queue) {
        this.generateQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (generateQueue) {
                while (generateQueue.isEmpty()) {
                    try {
                        generateQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int number = generateQueue.poll();
                if(number % 2 == 0) {
                    System.out.println("The number is Even. Square of the number " + number + " is " + (number*number));
                }
                else {
                    System.out.println("The number is Odd. The number is: " + number);
                }
            }
        }
    }
}
