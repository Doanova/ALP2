/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition.ui;

import competition.app.Competition;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helen
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Competition c = new Competition();
        System.out.println("Zadej nazvy vstupnich souboru");
        try{
            while(true){
                try {
                    String startFile = sc.next();
                    String finishFile = sc.next();
                    c.load(startFile, finishFile);
                    break;
                }catch(FileNotFoundException e){
                    System.out.println("Zadany neexistujici subor. Zadej znovu.");
                    //e.printStackTrace(); vhodné pro debuggování
                }
            }
                System.out.println(c.getResults());
                System.out.println("Zadej nazev vystupniho souboru");
                String resultFile = sc.next();
                c.saveResults(resultFile);
                System.out.println("Data byla ulozena");
        }catch(IOException e){
            System.out.println("Chyba pri cteni a zapisu");
        }
    }
}
