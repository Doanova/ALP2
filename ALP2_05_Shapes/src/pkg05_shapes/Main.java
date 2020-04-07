package pkg05_shapes;

import java.util.ArrayList;

/**
 *
 * @author helen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceD(8);
        Rectangle r1 = new Rectangle(2,3);
        Circle c2 = Circle.getInstanceR(2.6);
        
        System.out.println("1.varianta");
        double allArea1 = c1.computeArea() + r1.getArea() + c2.computeArea();
        System.out.println(allArea1);
        
        System.out.println("2.varianta");
        ArrayList shapes2 = new ArrayList(); //dynamické pole objektů typu Objects(nejvyšší datový typ aký existuje)
        // muze obsahovat cokoli, co je typově kompatibilní s Objects (vsechno)
        shapes2.add(c1);
        shapes2.add(r1);
        shapes2.add(Circle.getInstanceR(2.6));
        
        double allArea2 = 0;
        for (int i = 0; i < shapes2.size(); i++) {  //going trough using index
            if(shapes2.get(i) instanceof Circle){
            allArea2 += ((Circle)shapes2.get(i)).computeArea();
            }else if(shapes2.get(i) instanceof Rectangle){
            allArea2 += ((Rectangle)shapes2.get(i)).computeArea();
            }
        }
        System.out.println(allArea2);
        
        System.out.println("3.varianta");
        ArrayList<Shape> shapes3= new ArrayList<>();    //dynamické pole objektů typu Shape
        //muze obsahovat cokoli, co je typově kompatibilní s Shape (Shape, Circle, Rectangle)
        //Shape s = new Rectangle(5,6);
        //Rectangle r = new Shape(); // nejde
        shapes3.add(c1);
        shapes3.add(r1);
        shapes3.add(Circle.getInstanceR(2.6));
        double allArea3 = 0;
        for (Shape shape : shapes3) {     //foreach
            allArea3 += shape.computeArea(); //polymorfismus - metoda computeArea se tvoří mnohotvarne - za nejakych okolnosti ukazuje na jeden kod/ za jinych okolnosti na jiny kod
        }                                    // metoda se vyhodnotí v průběhu programu
        System.out.println(allArea3);
    }
    
}
