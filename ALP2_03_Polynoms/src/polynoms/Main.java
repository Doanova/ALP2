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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //5x3 + 3x2 - 0x1 +6
        double[] a = {6, 0, 3, 5};
        Polynom p1 = Polynom.getInstanceReverted(a);
        System.out.println(p1);
        System.out.println(p1.getCoefAt(3));
        System.out.println(p1.derivate());
        System.out.println(p1.computeValue(2));
        System.out.println(p1.integrate(3, 5));
        System.out.println("");

        //5x3 + 3x2 - 2x1 +6
        double[] b = {6, -2, 3, 5};
        Polynom p2 = Polynom.getInstanceReverted(b);
        System.out.println(p2);
        System.out.println("");
        //5x2 + 3x1 - 2
        double[] c = {-2, 3, 5};
        Polynom p3 = Polynom.getInstanceReverted(c);
        System.out.println(p3);
        System.out.println("");
        
        Polynom ps1 = Polynom.getInstance(5,3,0,6);
        Polynom ps2 = Polynom.getInstance(6,3,1);
        System.out.println(Polynoms.sum(ps1, ps2));
        System.out.println(Polynoms.multiply(ps1, ps2));
        System.out.println("");
        
        Polynom ps4 = Polynom.getInstance(5,3,0,6);
        Polynom ps3 = Polynom.getInstance(6,3,1);
        System.out.println(Polynoms.multiply(ps3, ps4));
    }
    
}
