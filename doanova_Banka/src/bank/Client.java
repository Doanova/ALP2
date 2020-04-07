/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author helen
 */
public abstract class Client {
    
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();
    
    public void addAccount(double money){
        Account a = new Account(money);
        accounts.add(a);
    }
    
    public double allMoney(){
        double allMoney = 0;
        for (Account a : accounts) {
            allMoney += a.getMoney();
        }
        return allMoney;
    }

    
    public abstract String getName();
    
    
}
