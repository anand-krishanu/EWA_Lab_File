package Exp9;

public class Exp9 {
    public static void main(String[] args) {
        HelloJava hellojava = new HelloJava(1);
        Thread thread = new Thread(hellojava);
        thread.start();
    }
}
