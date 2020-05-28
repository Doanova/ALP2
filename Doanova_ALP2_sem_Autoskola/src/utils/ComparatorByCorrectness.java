/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.Result;
import java.util.Comparator;

/**
 *
 * @author helen
 */
public class ComparatorByCorrectness implements Comparator<Result> {

    @Override
    public int compare(Result o1, Result o2) {
        return o1.getCorrectness().compareTo(o2.getCorrectness());
    }
    


 
}
