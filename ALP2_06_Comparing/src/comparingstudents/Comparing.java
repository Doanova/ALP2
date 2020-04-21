/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import java.text.Collator;
import static mycomparing.MyComparing.print;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author helen
 */
public class Comparing {
    
     public static void main(String[] args) {
        Student[] students = DataSource.loadDataAsArray();
        print(students);
        
        //TO DO pridat studentum znamky 
        
        //test shodnosti objektu
        // nemusí být stejný objekt, stačí když má stejná data
         System.out.println(students[0].equals(students[1]));
        // System.out.println(students[0].equals(students[4]));
         //System.out.println(students[0].equals(students[3]));
        
        System.out.println("Sort by number");
        //sortByNumber(students);
        //sort(students);
        Arrays.sort(students); // students musí být typově kompatibilní s interface Comparable
        print(students);
        
        List<Student> students1 = DataSource.loadDataAsList();
        System.out.println("Sort by number");
        Collections.sort(students1);
        print(students);
        
        System.out.println("Sort by firstname");
        Arrays.sort(students, new ComparatorByFirstname()); //nemusi byt typove kompatibilni s Comparable
        print(students);
        
        System.out.println("Sort by lastname");
        Arrays.sort(students, new Comparator<Student>() {   //anonymní třída implementující Comparator interface       - když vim, že ji budu volat jen 1x
            @Override
            public int compare(Student o1, Student o2) {
                Collator col = Collator.getInstance(new Locale("cs","CZ")); //tovarni metoda
                return col.compare(o1.getLastname(),o2.getLastname());
                //return o1.getLastname().compareTo(o2.getLastname()); //trideni Stringu podle ASCII
            }
        }); //nemusi byt typove kompatibilni s Comparable
        print(students);
       
        //lambda výraz
        //Arrays.sort(students,Student o1, Student o2 );
        
        int[] gradesStudent1 = {1,1,2,1,2,1,1};
        int[] gradesStudent2 = {1,2,2,2,4,5,3};
        int[] gradesStudent3 = {5,5,5,5,5,4,3};
        
        students[0].addGrade(gradesStudent1);
        students[1].addGrade(gradesStudent2);
        students[2].addGrade(gradesStudent3);
        
        students[0].getGrade();
        
        //TO DO setridit podle primeru 
        System.out.println("Sort by grades");
        Arrays.sort(students, new ComparatorByGrades());
        print(students);
        
        System.out.println(students[0].getAvarage()+"   "+students[0].getFirstname());
        System.out.println(students[1].getAvarage()+"   "+students[1].getFirstname());
        System.out.println(students[2].getAvarage()+"   "+students[2].getFirstname());
         System.out.println("");

    }
    
}
