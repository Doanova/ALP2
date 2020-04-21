package comparingstudents;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author helen
 */
public class DataSource {
    
    private static Student[] data = {               //private ---- meli bychom vracet kopii !!!!
        new Student("Alice","Mala", 345),
        new Student("Bob", "Velky", 123),
        new Student("Cyril", "Stredny", 567),
        //new Student("Alice","Mala", 345),
        //new Student("Tereza","Mensi", 345)
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);    //-----vracím kopii !!!
    }
    
    public static List<Student> loadDataAsList(){ //dinamické pole
        return Arrays.asList(data);
//        ArrayList<Sttudent> students = new ArrayList<>();
//        students.addAll(Arrays.asList(data));
    }
    
    
}
