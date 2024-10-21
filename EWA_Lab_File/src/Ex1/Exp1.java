package Ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Exp1 {
    public void readWords () {
        try {
            final String filePath = "C:/Users/Krishanu Anand/eclipse-workspace/Group5/src/com/Group5/Words.txt";

            File file = new File(filePath);

            ArrayList<String> allWords = new ArrayList<>();
            Scanner sc = new Scanner(file);

            while(sc.hasNext()) {
                String word = sc.next();
                allWords.add(word);
            }
            System.out.println("All Words: ");
            System.out.println(allWords);
            System.out.println();

            ListIterator<String> reverseIterator = allWords.listIterator(allWords.size());

            System.out.println("Words in reversed order: ");
            while (reverseIterator.hasPrevious()) {
                System.out.println(reverseIterator.previous());
            }
            System.out.println();

            ListIterator<String> iterator = allWords.listIterator();
            ArrayList<String> pluralWords = new ArrayList<>();

            while(iterator.hasNext()) {
                String currentWord = iterator.next();
                if(currentWord.endsWith("s")) {
                    pluralWords.add(currentWord);
//            		System.out.println(currentWord);
                    iterator.remove();
                }
            }

            System.out.println();
            System.out.println("ArrayList with all Plural Words: ");
            System.out.println(pluralWords);

            System.out.println();
            System.out.println("ArrayList after plural words removed: ");
            System.out.println(allWords);
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("FILE PATH IS INCORRECT!");
            System.out.println(e);
        }
    }
}
