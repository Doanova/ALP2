/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynoms;

/**
 *
 * @author helen
 */
public class Polynoms {
    
    //knihovni trida/library class -- jen statické metody
    private Polynoms(){ // nemuze se vytvorit objekt -- vymazala jsem timhle defaultni kostruktor
    
    }
    
    public static Polynom sum(Polynom a, Polynom b){
        boolean isBigger = a.getDegree() > b.getDegree();
        Polynom max = isBigger ? a : b;     //Math.max(a.getDegree(),b.getDegree())
        Polynom min = isBigger ? b : a;
        
        double[] sumCoef = new double[max.getDegree()+1];
        //6 0 3 5
        //1 3 6
        //-------
        //7 3 9 5
        for (int i = 0; i < max.getDegree()+1; i++) {
            sumCoef[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree()+1; i++) {
            sumCoef[i] = sumCoef[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sumCoef);
    }
    
    //TODO
    //součin
    public static Polynom multiply(Polynom a, Polynom b){   
        int lenA = a.getDegree();
        int lenB = b.getDegree();
       
        double[] A = a.getAllCoef();
        double[] B = b.getAllCoef();
        double[] multi = new double[lenA + lenB +1];
        for (int i = 0; i < multi.length; i++) {
            multi[i] = 0;               
        }
        for (int i = 0; i < lenA+1; i++) {
            for (int j = 0; j < lenB+1; j++) {
                multi[i+j] += A[i]*B[j] ;
            }
        }
        
        return Polynom.getInstanceReverted(multi);
    }
    
    
    
    

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        Polynom p1 = Polynom.getInstance(5,3,0,6);
//        Polynom p2 = Polynom.getInstance(6,3,1);
//        System.out.println(Polynoms.sum(p1, p2));
//        System.out.println(Polynoms.multiply(p1, p2));
//        
//        Polynom p4 = Polynom.getInstance(5,3,0,6);
//        Polynom p3 = Polynom.getInstance(6,3,1);
//        System.out.println(Polynoms.multiply(p3, p4));
//        
//        
//    }
    
}
