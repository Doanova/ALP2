package pkg05_shapes;

/**
 *
 * @author helen
 */
public abstract class Shape implements Comparable<Shape>{   //abstract - nebudou se z ní vytvářet objekty   //předek
    //data
    protected String name ="Geometric object";    // aby bylo videt i v potomcích --> protected
                                                    // zpusob jak dědit atributy
    
    public abstract double computeArea(); // musí být překritá v potomcích
    
    public String getShapeName(){
        return this.getClass().getSimpleName(); //použitá metoda jen v potomcích 
    
    }
    
    @Override
    public String toString(){ // prekrývá toString tridy Object, defaultni implementace, ktera muze byt prekryta
    return name + ": " + getShapeName();
    }

    @Override
    public int compareTo(Shape o) {
        if(this.computeArea() > o.computeArea()){
            return 1;
        }else if(computeArea() < o.computeArea()){
            return 0;
        }
        return -1;    
    }

}
