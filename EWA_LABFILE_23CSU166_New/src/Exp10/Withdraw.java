package Exp10;

public class Withdraw implements Runnable{

    private BankAccount account;
    private int amount;

    public Withdraw(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}