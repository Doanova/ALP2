/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Comparator;

/**
 *
 * @author helen
 */
public class ComparatorByCorrectness implements Comparator<Result> {

    @Override
    public int compare(Result o1, Result o2) {
        return o1.getCorrectnes().compareTo(o2.getCorrectnes());
    }

 
}
