package Exp8;

import java.util.ArrayList;

public class FactorsThread implements Runnable {
    int num;

    public FactorsThread (int num) {
        this.num = num;
    }

    @Override
    public void run() {

        ArrayList<Integer> printFactors = factors(num);
        for (int i = 0; i < printFactors.size(); i++) {
            System.out.println("Factor: " +printFactors.get(i));
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Integer> factors (int num) {
        ArrayList<Integer> factorsList = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            if(num % i == 0) {
                factorsList.add(i);
            }
        }
        return factorsList;
    }
}
