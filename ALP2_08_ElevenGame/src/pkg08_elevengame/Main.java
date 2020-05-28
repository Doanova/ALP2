/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg08_elevengame;

import java.util.Scanner;

/**
 *
 * @author helen
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static BordInterface bord;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*********** " + bord.getName() + " ***********");
        displayCards();
        displayDeck();
        while (bord.isAnotherPlayPossible()) {  //este existuje JQK, nebo suma 11 v balicku
            System.out.println("Vyber karty:");
            String[] selectedCardsPositions = sc.nextLine().split(" +");
            if (!bord.playAndReplace(selectedCardsPositions)) {
                System.out.println("Nevalidní tah");
            } else {
                displayCards();
                displayDeck();
            }
        }
        if(bord.hasWon()){
            System.out.println("Gratuluji");
        }else{
            System.out.println("Nelze hrát");
        }
    }

    private static void displayCards() {
        //koule-2
        for (int i = 0; i < bord.nCards(); i++) {
            System.out.format("%1d. %20s ", i + 1, bord.getCardDescriptionAt(i));
            if ((i + 1) % 3 == 0) {
                System.out.println("");
            }
        }
    }

    private static void displayDeck() {
        System.out.println("V balicku je " + bord.getDeckSize() + " karet");
    }

}
