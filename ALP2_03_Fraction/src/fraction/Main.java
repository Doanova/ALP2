/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraction;

import static fraction.Fraction.gdc;
import static fraction.FractionsCalculator.add;
import static fraction.FractionsCalculator.divide;
import static fraction.FractionsCalculator.multiply;
import static fraction.FractionsCalculator.sub;

/**
 *
 * @author helen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraction f1 = new Fraction(-9,6);
        Fraction f2 = new Fraction("5/6");
        Fraction f3 = new Fraction(-20,-10);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println("");
        
        Fraction a = new Fraction(5,3);
        Fraction b = new Fraction(7,2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(add(a,b));
        System.out.println(sub(a,b));
        System.out.println(multiply(a,b));
        System.out.println(divide(a,b));
        
    }
    
}
