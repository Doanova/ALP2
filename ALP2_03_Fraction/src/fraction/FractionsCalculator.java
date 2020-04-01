/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraction;

/**
 *
 * @author helen
 */
public class FractionsCalculator {
    
    public static Fraction add(Fraction a, Fraction b){
        int numA = a.getNumerator();
        int denA = a.getDenominator();
        int numB = b.getNumerator();
        int denB = b.getDenominator();
        int denC = Fraction.gdc(denA,denB);
        denC = (denA*denB)/denC;
        int numC = numA * (denC/denA) + numB * (denC/denB);
        return new Fraction(numC,denC);
    }
    
    public static Fraction sub(Fraction a, Fraction b){
        int numA = a.getNumerator();
        int denA = a.getDenominator();
        int numB = b.getNumerator();
        int denB = b.getDenominator();
        int denC = Fraction.gdc(denA,denB);
        denC = (denA*denB)/denC;
        int numC = numA * (denC/denA) - numB * (denC/denB);
        return new Fraction(numC,denC);
    }
    
    public static Fraction multiply(Fraction a, Fraction b){
        int numA = a.getNumerator();
        int denA = a.getDenominator();
        int numB = b.getNumerator();
        int denB = b.getDenominator();
        int numC = numA * numB;
        int denC = denA * denB;
        return new Fraction(numC,denC);
    }
    
    public static Fraction divide(Fraction a, Fraction b){
        int numA = a.getNumerator();
        int denA = a.getDenominator();
        int numB = b.getNumerator();
        int denB = b.getDenominator();
        int numC = numA * denB;
        int denC = denA * numB;
        return new Fraction(numC,denC);
    }

    
}
