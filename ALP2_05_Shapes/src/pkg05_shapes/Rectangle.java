/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_shapes;

/**
 * Nemenny immutable
 * @author helen
 */
public class Rectangle extends Shape {
    //data
    private double a;
    private double b;
    private double area; // proměnná ktera je vypočítaná

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = area(); //muze byt překritá když je publiv --> v konstruktoru volat jen privátní metody !!!
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
    
    private double area(){
        return a*b;
    }

    //tato metoda není už potřebná
    public double getArea() {
        return area;
    }
    
    @Override
    public double computeArea(){
     return area;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "a=" + a + ", b=" + b + '}';
    }
    
    
}
