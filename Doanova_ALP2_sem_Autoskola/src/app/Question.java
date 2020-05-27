/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author helen
 */
public class Question implements Comparable<Question> {
    private int id;
    private String question;
    private String a;
    private String b;
    private String c;
    private String correct;

    public Question(int id, String question, String a, String b, String c,String correct) {
        this.id = id;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getCorrect() {
        return correct;
    }

    @Override
    public String toString() {
        return "Question id= " + id + ", question= " + question + ", correct= " + correct;
    }

    @Override
    public int compareTo(Question o) {
        return this.getId() - ((Question)o).getId();
    }
    
    
    
    
    
    
}
