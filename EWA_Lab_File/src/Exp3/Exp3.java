package Exp3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Exp3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> driveway = new Stack<>();
        int num;

        System.out.println("Enter number of cars: ");
        int n = sc.nextInt();
        System.out.println("Enter License number: ");
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            driveway.push(num);
        }
        System.out.println(driveway);

        System.out.println("Enter Car Number to remove: ");
        int check = sc.nextInt();

        Queue<Integer> street = new LinkedList<>();
        int temp;

        while(!driveway.isEmpty()) {
            temp = driveway.peek();
            if(temp != check) {
                temp = driveway.pop();
                street.add(temp);
            } else {
                System.out.print("Car removed: ");
                System.out.println(driveway.pop());
                break;
            }
        }

        int addToStack;
        while(!street.isEmpty()) {
            addToStack = street.remove();
            driveway.push(addToStack);
        }
        System.out.println(driveway);
    }
}
