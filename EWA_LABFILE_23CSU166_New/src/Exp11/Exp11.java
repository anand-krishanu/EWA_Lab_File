package Exp11;

public class Exp11 {
    public static void main(String[] args) {
        int initialBalance = 200;

        BankAccount2 account = new BankAccount2(initialBalance);

        Thread monica = new Thread(new Producer(account, 5));
        Thread ryan = new Thread(new Consumer(account, 10));

        monica.start();
        ryan.start();

        try {
            monica.join();
            ryan.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All transactions completed.");
    }
}
