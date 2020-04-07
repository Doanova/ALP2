/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_shapes;

/**
 *
 * @author helen
 */
public class Square extends Rectangle{
    
    private double a;
    private double area;

    public Square(double a) {
        super(a,a);
        this.a = a;   
        this.area = super.getArea();  
    }

    @Override
    public String toString() {
        return "Sqare{" + "a=" + a + '}';
    }
    
    public static void main(String[] args) {
        Square s = new Square(5);
        System.out.println(s.computeArea());
        System.out.println(s.area);
                
    }
    
}
