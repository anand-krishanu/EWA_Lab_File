package Exp10;

public class Exp10 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        Withdraw ryanTask = new Withdraw(account, 50);
        Withdraw monicaTask = new Withdraw(account, 50);

        Thread ryan = new Thread(ryanTask, "Ryan");
        Thread monica = new Thread(monicaTask, "Monica");

        ryan.start();
        monica.start();
    }
}
