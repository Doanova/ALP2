/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg05_shapes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author helen
 */
public class ShapesApp {

    /**
     * @param args the command line arguments
     */
    
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Shape> shapes = new ArrayList<>();
    
    public static void main(String[] args) {

        boolean end = false;
        while(!end){
        displayMenu();
        int choice = readChoice();
        switch(choice){
            case 0:
                end = true;
                break;
            case 1:
                clearObject();
                break;
            case 2: 
                addSquare();
                break;
            case 3:
                addCircle();
                break;
            case 4:
                addRectangle();
                break;
            case 5:
                computeArea();
                break;
            case 6:
                printObjects();
                break;
            case 7:
                maxArea();
                break;
            default:
                System.out.println("Zadana neplatna volba");
        
        }
        
        }
        
    }

    private static void displayMenu() {
        System.out.println("1. Nový list");
        System.out.println("2. Přidej čtverec");
        System.out.println("3. Přidej kruh");
        System.out.println("4. Přidej obdelník");
        System.out.println("5. Vypočítej celkovou plochu objektů");
        System.out.println("6. Vypiš objekty");
        System.out.println("7. Najdi objekt s nevětším obvodem");
        System.out.println("0. Konec programu");
    }

    private static int readChoice() {
        int choice = -1;
        System.out.println("Zadej číslo polozky: ");
        try{
            choice = sc.nextInt();
        }catch(InputMismatchException e){
            choice = -1;
        }finally{
            sc.nextLine();
        }
        return choice;
    }

    private static void clearObject() {
        shapes.clear();
    }

    private static void addSquare() {
         System.out.println("Zadej stranu a: ");
         double a = sc.nextDouble();
         Square s = new Square(a);
         shapes.add(s);
    }

    private static void addCircle() {
        System.out.println("Vyber: 1 = polomer    2 = prumer");
        int choice = sc.nextInt();
        if(choice == 1){
            double r = sc.nextDouble();
            Circle c = Circle.getInstanceR(r);  
            shapes.add(c);
        }
        if(choice == 2){
            double d = sc.nextDouble();
            Circle c = Circle.getInstanceD(d);
            shapes.add(c);
        }
    }

    private static void addRectangle() {
        System.out.println("Zadej stranu a: ");
        double a = sc.nextDouble();
        System.out.println("Zadej stranu b: ");
        double b = sc.nextDouble();
        Rectangle r = new Rectangle(a,b);
        shapes.add(r);
    }

    private static void computeArea() {
        double allArea = 0;
        for (Shape s : shapes) {
            allArea += s.computeArea();
        }
        System.out.println(allArea);
    }

    private static void printObjects() {
        for (Shape s : shapes) {
            System.out.println(s);
        }
    }

    private static void maxArea() {
        double maxArea = 0;
        Shape maxShape = null;
        for (Shape s : shapes) {
            double sArea = s.computeArea();
            if( sArea > maxArea){
                maxArea = sArea;
                maxShape = s;
            }
        }
        System.out.println("Objekt s největším obvodem je: " + maxShape + " a jeho objem je: " + maxArea);
    }
    
}
