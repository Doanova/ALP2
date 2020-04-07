/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bank.Client;
import bank.Company;
import bank.Person;
import java.util.ArrayList;

/**
 *
 * @author helen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        
        Person pekar = new Person("Pekar");
        Person svecova = new Person("Svecova");
        Company skoda = new Company("Skoda");
        
        clients.add(pekar);
        clients.add(svecova);
        clients.add(skoda);
        
        System.out.println(pekar.allMoney());
        
        pekar.addAccount(1000);
        pekar.addAccount(500);
        svecova.addAccount(1200);
        skoda.addAccount(120);
        
        
        System.out.println("Klient:                 Suma:");
        for (Client c : clients) {
            System.out.println(c.getName() + "                " +c.allMoney());   
        }
        
       
    }
    
}
