package Exp14;

import java.util.Scanner;

interface GreetService {
    String greet(String name);
}

class EnglishGS implements GreetService{

    @Override
    public String greet (String name) {
        return "Hello " + name;
    }
}

class FrenchGS implements GreetService{

    @Override
    public String greet (String name) {
        return "Bonjour " + name;
    }
}

class SpanishGS implements GreetService {

    @Override
    public String greet (String name) {
        return "Hola " + name;
    }
}

class GreetServiceFactory {
    public static GreetService getGreetService (String language) throws Exception {
        switch (language.toLowerCase()) {
            case "english" :
                return new EnglishGS();
            case "french" :
                return new FrenchGS();
            case "spanish" :
                return new SpanishGS();
            default:
                throw new Exception("Language: " + language + " not supported");
        }
    }
}

public class Main {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a name: ");
        String name = sc.next();

        System.out.println("Enter a language: ");
        String language = sc.next();

        GreetService greetService = GreetServiceFactory.getGreetService(language);
        System.out.println(greetService.greet(name));

//        GreetServiceFactory greetServiceFactory = new GreetServiceFactory();
//        System.out.println(greetServiceFactory.getGreetService(language).greet(name));
    }
}