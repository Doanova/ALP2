package pkg05_shapes;

/**
 *
 * @author helen
 */
public class Circle extends Shape{  //Circle je typově kompatibilní s Shape ---- Circle je potomek ---extends - rozšiřuje --- Shape
    //data                          //Circle IS A Shape
    private double r;

    private Circle(double r) {  //private protoze mame tovarni metodu(tady je to zakazane vytvaret - vytvari se pomoci getInstance)
        this.r = r;
    }
    
   
//    public Circle(double d) { // toto nejde 
//        this.r = d/2.0;
//    }
    
    //tovarni metoda/factory method - pres konstruktory nejde vytvorit --- 2 konstruktory se stejnym vstupen !
    public static Circle getInstanceD(double d){
        return new Circle(d/2);
    }
    
        public static Circle getInstanceR(double r){
        return new Circle(r);
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + '}';
    }
    
    @Override
    public double computeArea(){
        return Math.PI*r*r;
    }
    
    
    
    public static void main(String[] args){
        Circle c1 = Circle.getInstanceR(4);
        System.out.println(c1);
        System.out.println(c1.computeArea());
    }
    
}
