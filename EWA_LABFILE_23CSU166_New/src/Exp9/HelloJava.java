package Exp9;

public class HelloJava implements Runnable{
    int threadNumber;

    public HelloJava(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        if (threadNumber < 50) {
            HelloJava t = new HelloJava(threadNumber + 1);
            Thread next = new Thread(t);

            next.start();
            try {
                next.join();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello Java from Thread: " +threadNumber);
    }
}
