
package interfaceVariant;

/**
 * Nemenny immutable
 * @author helen
 */
public class Rectangle implements ShapeInterface {
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
        //return super.toString() + String.format(" a = %2f, b = %2f", a,b);
    }
    
    
}
