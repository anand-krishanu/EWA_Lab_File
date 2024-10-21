package Exp2;

import java.util.Scanner;
import java.util.Stack;

public class Exp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String: ");
        String words = sc.nextLine();

        Stack<String> wordsStack = new Stack<>();
        int i = 0;
        for (String word : words.split(" ")) {
            //if . then: capitalize, remove ., while(!empty) { pop sysout} sysout(.)
            if(i == 0) {
                word = makeLowerCase(word);
            }

            if(word.endsWith(".")) {
                word = capitalize(word.substring(0, word.length() - 1));
                wordsStack.push(word);
                break;
            }

            wordsStack.push(word);
            i++;
        }

        while (!wordsStack.isEmpty()) {
            System.out.print(wordsStack.pop() + " ");
        }
        System.out.print(".");
    }

    public static final String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static final String makeLowerCase(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
}
