package ui;

import app.AutoskolaLogic;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author helen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AutoskolaLogic a = new AutoskolaLogic();
        boolean run = true;

        while (run) {
            System.out.println("Test Autoškola");
            try {
                try {
                    a.loadQ("Questions_Answers.txt");
                    a.Selection();
                } catch (FileNotFoundException e) {
                    System.out.println("Zadán špatný soubor");
                }
                //Timer timer = new Timer();

                for (int i = 0; i < 5; i++) {
                    if (i == 0) {
                        a.startMeasureTime();
                    }

                    System.out.print(i + 1 + ") ");
                    System.out.println(a.printQuestion(i));

                    while (!a.getAnswer(sc.nextLine(), i)) {
                        System.out.println("Vlož a/b/c: ");

                    }

                }
                a.endtMeasureTime();

                boolean result = true;
                while (result) {
                    System.out.println("Celkový čas testu: " + a.totalTime().getSeconds() + "sec");

                    System.out.println("Možnosti vypsání výsledků: ");
                    System.out.println("1. Výpis v pořadí, v jakém byly otázky");
                    System.out.println("2. Výpis - nejdříve vypíše otázky, na které jsi odpověděl špatně.");
                    System.out.println("3. Výpis podle originálního id.");
                    String choice = sc.next();
                    if(choice.equals("1")){
                        System.out.println(a.getResults());
                    }else if(choice.equals("2")){
                        System.out.println(a.sortByCorrectness());
                    }else if(choice.equals("3")){
                        System.out.println(a.sortById());
                    }else{
                        System.out.println("Vlož buď 1/2/3");
                    }

                    if(choice.equals("1")||choice.equals("2")||choice.equals("3")){
                    System.out.println("Chcete ukoncit zobrazovani výsledků: Y pro ano");
                    }
                    String choice2 = sc.next();
                    if (choice2.equals("Y")) {
                        result = false;
                    }

                }
                String name;
                System.out.println("Chceš uložit vysledky jako: ");
                System.out.println("A) Textovy soubor");
                System.out.println("B) Textovy soubor");
                String choice3 = sc.next();
                if(choice3.equals("A")){
                    System.out.println("zadej jmnéno souboru: ");
                    name = sc.next();
                    name = name + ".txt";
                    a.saveResult(name);
                }else{
                    System.out.println("zadej jmnéno souboru: ");
                    name = sc.next();
                    name = name + ".dat";
                    a.saveResult(name);
                }
//                String name =  sc.next();
//                a.saveResult(name);
                
                
                System.out.println("Chceš ukončit program? Jestli ano zadej Y");
                String end = sc.next();
                if(end.equals("Y")){
                    run = false;
                }
               
            } catch (IOException e) {
                System.out.println("Chyba při čtení a zápisu");
            }

        }

    }
}
