package Exp11;

public class Producer implements Runnable{
    private BankAccount2 account;
    private int depositLimit;

    public Producer(BankAccount2 account, int depositLimit) {
        this.account = account;
        this.depositLimit = depositLimit;
    }

    @Override
    public void run() {
        for (int i = 0; i < depositLimit; i++) {
            int depositAmount = 100;
            account.deposit(depositAmount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
