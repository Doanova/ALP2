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
public class Result  {
    private int index;
    private String answer;
    private String correctAnswer;
    //private String time;

    public Result(int index, String answer, String correct) {//String time
        this.index = index;
        this.answer = answer;
        this.correctAnswer = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
    
    
    public String getCorrectnes(){
        String correctness;
        if(this.answer.equals(this.correctAnswer)){
            correctness = "spravne";
        }else{
            correctness = "spatne";
        }
        return correctness;
    }


    @Override
    public String toString() {
        String correctness;
        if(answer.equals(correctAnswer)){
            correctness = "správně";
            return String.format("%-15s%-15s%-20s",answer,correctAnswer,correctness);
        }
        correctness = "špatně";
        return String.format("%-15s%-15s%-20s",answer,correctAnswer,correctness);
    }

    
    
    
    
    
//    public static void main(String[] args){
//        Result r = new Result(1,"c","b");
//        System.out.println(r);
//    }


    
    
}
