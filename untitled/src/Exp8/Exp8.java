package Exp8;

import java.util.Scanner;

public class Exp8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        FactorialThread factorial = new FactorialThread(num);
        FactorsThread factors = new FactorsThread(num);

        Thread t1 = new Thread(factorial);
        Thread t2 = new Thread(factors);

        t1.start();
        ;
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
