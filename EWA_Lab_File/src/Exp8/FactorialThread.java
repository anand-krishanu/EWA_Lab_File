package Exp8;

public class FactorialThread implements Runnable{
    int num;

    FactorialThread (int num) {
        this.num = num;
    }

    @Override
    public void run () {
        System.out.println();
        System.out.println("Factorial Answer: " +factorial(num));
    }

    public int factorial (int num) {
        int ans = 1;

        for (int i = 1; i < num; i++) {
            ans = ans*i;
            System.out.println("Calculating Factorial: " +ans);
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return ans;
    }
}
