/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import mycomparing.CompareInterface;
import java.util.Objects;

/**
 *
 * @author helen
 */
public class Student implements CompareInterface, Comparable{
    
    private String firstname;
    private String lastname;
    private int studentNumber;
    //HW
    //TO DO pole známke  , vytvorit metodu na pridavani znamek   
    private int[] grades;
    

    public Student(String firstname, String lastname, int studentNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentNumber = studentNumber;
        this.grades = new int[7]; //max 7 grades
        for (int i = 0; i < grades.length; i++) {
            grades[i] = 0;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
    
    public void getGrade(){
        for (int grade : grades) {
            System.out.println(grade);
        }
    
    }
    
    public void addGrade(int[] grades){
        System.out.println("Zapis 7 známek");
        for (int i = 0; i < this.grades.length; i++) {
            this.grades[i] = grades[i];
        }
    }

    //TO DO calculateAverage
    public double getAvarage(){
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        sum = sum/7;
       return sum; 
    }
    
    
    @Override
    public String toString() {
        return String.format("%10s%10s%10d",firstname, lastname, studentNumber);
    }

    boolean isBigger(Student student) {
        return this.studentNumber > student.studentNumber; 
    }

    @Override
    public boolean isBigger(CompareInterface o) {
        return this.studentNumber > ((Student)o).studentNumber; 
    }

    @Override
    public int compareTo(Object o) {
        return this.studentNumber - ((Student)o).studentNumber;
    }

    //pre změně equeals bych měla změnit i hash
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.firstname);
        hash = 13 * hash + Objects.hashCode(this.lastname);
        hash = 13 * hash + this.studentNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        return true;
    }
    
    
    
}
