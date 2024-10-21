package Exp11;

public class Consumer implements Runnable{
    private BankAccount2 account;
    private int withdrawLimit;

    public Consumer(BankAccount2 account, int withdrawLimit) {
        this.account = account;
        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public void run() {
        for (int i = 0; i < withdrawLimit; i++) {
            int withdrawAmount = 50;
            try {
                account.withdraw(withdrawAmount);
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
