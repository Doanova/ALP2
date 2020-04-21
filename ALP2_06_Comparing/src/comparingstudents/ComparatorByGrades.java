/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import java.util.Comparator;

/**
 *
 * @author helen
 */
public class ComparatorByGrades implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAvarage() > o2.getAvarage()) {
            return 1;
        }
        return -1;
    }
}