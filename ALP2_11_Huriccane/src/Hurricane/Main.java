/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hurricane;

import java.util.Scanner;

/**
 *
 * @author helen
 */

public class Main {
    public static void main(String[] args) {
       HurricaneInterface hI = new DataHurricane();
       Scanner sc = new Scanner(System.in);
       int yearFrom;
       int  yearTo;
       String hurricane;
       
       try{
            hI.load();
        }catch(Exception e){
            System.out.println("Neplatny soubor");
        }
        System.out.println("Vypis informaci o hurikanech v danem obdobi");
        System.out.println("Od roku: ");
        yearFrom = sc.nextInt();
        System.out.println("Do roku:");
        yearTo = sc.nextInt();
        System.out.println(hI.hurricanesPeriod(yearFrom, yearTo));
        
        System.out.println("Vypis kategorie a rychlosti zadaneho hurikanu");
        hurricane = sc.next();
        System.out.println(hI.hurricaneByName(hurricane));
        
        System.out.println("Vypis informaci o hurikanech setridenych podle rychlosti");
        System.out.println(hI.hurricaneBySpeed());
       
    }
        
}


