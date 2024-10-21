package Exp5;

import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class Exp5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String dictionaryPath = "D:/NCU B. Tech/Semester 3/Dictionary.txt";
        String wordsPath = "D:/NCU B. Tech/Semester 3/Words.txt";

        File dictionaryFile = new File(dictionaryPath);

        File wordsFile = new File(wordsPath);

        String str = "I am doing Leetcode";
        str.substring(str.lastIndexOf(" ") + 1);

        try (FileWriter dictionaryWriter = new FileWriter(dictionaryFile, true)) {
            String word;
            String meaning;

            System.out.println("Enter 3 words and meaning of the Dictionary: ");
            for (int i = 0; i <= 2; i++) {
                System.out.println("Enter word: ");
                word = sc.nextLine();

                System.out.println("Enter meaning: ");
                meaning = sc.nextLine();

                dictionaryWriter.write(word + "=" + meaning + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        Hashtable<String, String> dictionaryHT = new Hashtable<>();

        try (BufferedReader dictionaryReader = new BufferedReader(new FileReader(dictionaryFile))) {
            String eachLine;
            while ((eachLine = dictionaryReader.readLine()) != null) {
                String[] words = eachLine.split("=");

                if (words.length == 2) {
                    dictionaryHT.put(words[0], words[1]);
                }
            }

//            System.out.println("Dictionary: ");
//            System.out.println(dictionaryHT);
//            for (String key : dictionaryHT.keySet()) {
//                System.out.println(key);
//            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileWriter wordWriter = new FileWriter(wordsFile, true)) {
            String wordAlone;

            System.out.println("Enter 3 words: ");
            for (int i = 0; i <= 2; i++) {
                System.out.println("Enter word: ");
                wordAlone = sc.nextLine();

                wordWriter.write(wordAlone + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        try (BufferedReader wordReader = new BufferedReader(new FileReader(wordsFile))) {
            String eachWord;
//            System.out.println("Words in the Words file: ");
            while ((eachWord = wordReader.readLine()) != null) {
//                System.out.println(eachWord);
                if(eachWord.isEmpty()) {

                }
                else if (dictionaryHT.containsKey(eachWord)) {
                    System.out.println( "Word: " + eachWord + "  Meaning:  " +dictionaryHT.get(eachWord));
                }
                else {
                    System.out.println("Word not spelled correctly");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
