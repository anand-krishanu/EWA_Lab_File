package Exp11;

public class BankAccount2 {
    private int balance;

    public BankAccount2(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Monica deposited: " + amount + ". Current balance: " + balance);
        notify();
    }

    public synchronized void withdraw(int amount) throws InterruptedException {
        while (balance < amount) {
            System.out.println("Ryan is waiting to withdraw: $" + amount + " due to insufficient balance.");
            wait();
        }
        balance -= amount;
        System.out.println("Ryan withdrew: $" + amount + ". Current balance: $" + balance);
    }
}
