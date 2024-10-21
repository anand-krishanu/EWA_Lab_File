package Exp10;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void  withdraw (int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal. New balance: " + balance);
        } else {
            System.out.println("Not enough balance for " + Thread.currentThread().getName() + " to withdraw. Balance: " + balance);
        }
    }
}
