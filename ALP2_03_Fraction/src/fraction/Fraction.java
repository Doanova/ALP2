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
public class Fraction {
    
    //data 4 5 nebo "4/5"
    private int numerator;  //citatel
    private int denominator; //jmenovatel

    public Fraction(int numerator, int denominator) {
        Integer[] simplify = simplify(numerator,denominator);
        this.numerator = simplify[0];
        this.denominator = simplify[1];
    }

    public Fraction(String s){
        String[] part = s.split("/");
        int numerator = Integer.parseInt(part[0]);
        int denominator = Integer.parseInt(part[1]);
        Integer[] simplify = simplify(numerator,denominator);
        this.numerator = simplify[0];
        this.denominator = simplify[1];      
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public static int gdc(int a , int b){
        a = Math.abs(a);
        b = Math.abs(b);
        
        if(a==0) {
            return b;
        }
        return gdc(b%a,a);   
    }
                     
    public Integer[] simplify(int numerator, int denominator){
        int divisor = gdc(numerator,denominator);
        if(numerator < 0 && denominator < 0){
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        Integer[] simplify = {numerator/divisor, denominator/divisor} ;
        
        return simplify;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return  numerator + "/" + denominator ;
    }
  
}
