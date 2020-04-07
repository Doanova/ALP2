/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author helen
 */
public class Account {
    
    private double money = 0;

    public Account() {
        this.money = money;
    }
    
    public Account(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
    
    public void addMoney(double money){
        this.money += money;
    }
    
    public void takeMoney(double money){
        if(money > this.money){
            throw new IllegalArgumentException("Nedostatek peněz na uctu");
        }
        this.money -= money;
        
    }

    @Override
    public String toString() {
        return "Na účtu je" + money + " Kč";
    }
    
    
    
}
