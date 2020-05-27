package app;

import filehandling.BinaryWriter;
import filehandling.TextWriter;
import filehandling.Writer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author helen
 */
public class AutoskolaLogic {

    //potrebuju list kam ty otazky nacitat - a musi to byt novy datovy typ Question
    private ArrayList<Question> questions = new ArrayList<>();
    private Random randomGenerator = new Random();
    private ArrayList<Question> selectedQuestions = new ArrayList<>();
    private ArrayList<Result> results = new ArrayList<>();
    private Instant start, end;
    private Duration timeElapsed;
    private List<Question> idQuestions = new ArrayList<>();
    private Result[] correctness = new Result[5];

    //nacitani souboru
    public void loadQ(String fileName) throws FileNotFoundException, IOException {
        File questFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + fileName);
        //File questFile = new File("Questions_Answers");
        try (BufferedReader load = new BufferedReader(new FileReader(questFile))) {
            String line;
            while ((line = load.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String question = parts[1];
                String a = parts[2];
                String b = parts[3];
                String c = parts[4];
                String correct = parts[5];
                //System.out.println(correct);
                Question q = new Question(id, question, a, b, c, correct);
                questions.add(q);
            }

        }
    }

    public void Selection() {
        for (int i = 0; i < 5; i++) {
            int index = randomGenerator.nextInt(questions.size());
            Question q = questions.get(index);
            selectedQuestions.add(q);
            idQuestions.add(q);
        }
        //return selectedQuestions;
    }

    public String printQuestion(int index) {
        StringBuilder sb = new StringBuilder();

        sb.append(selectedQuestions.get(index).getQuestion() + "\n");
        sb.append(selectedQuestions.get(index).getA() + "\n");
        sb.append(selectedQuestions.get(index).getB() + "\n");
        sb.append(selectedQuestions.get(index).getC() + "\n");

        return sb.toString();
    }

    public Boolean getAnswer(String answer, int index) {
        String realCorrect = selectedQuestions.get(index).getCorrect();
        //String realCorrect = checkAnswer(answer,index);

        if (answer.equals("a")) {
            Result r = new Result(index, answer, realCorrect);
            results.add(r);
            correctness[index] = r;
            return true;
        } else if (answer.equals("b")) {
            Result r = new Result(index, answer, realCorrect);
            results.add(r);
            correctness[index] = r;
            return true;
        } else if (answer.equals("c")) {
            Result r = new Result(index, answer, realCorrect);
            results.add(r);
            correctness[index] = r;
            return true;
        } else {
            return false;
        }
    }

//    public void getArrayOfResult(String answer, int index){
//        String realCorrect =  selectedQuestions.get(index).getCorrect();
//        Result r = new Result(index, answer, realCorrect);
//            correctness[index] = r;       
//}
    public Instant startMeasureTime() {
        return start = Instant.now();
    }

    public Instant endtMeasureTime() {
        return end = Instant.now();
    }

    public Duration totalTime() {
        timeElapsed = Duration.between(start, end);
        return timeElapsed;
    }

    public String getResults() {
        //Collections.sort(results);
        StringBuilder sb = new StringBuilder();
        int n = 1;
        String num = "č.";
        String t = "Tvá odpověď";
        String s = "Správná odpověď";
        String v = "Výsledek";
        sb.append(String.format("%-5s%-15s%-20s%-20s%n", num, t, s, v));
        for (Result result : results) {
            sb.append(String.format("%-10d %s%n", n, result));
            n++;
        }
        return sb.toString();
    }

    public String sortByCorrectness() {
        Arrays.sort(correctness, new ComparatorByCorrectness());
        //Collections.sort(results);
        StringBuilder sb = new StringBuilder();
        int n = 1;
        String num = "č.";
        String t = "Tvá odpověď";
        String s = "Správná odpověď";
        String v = "Výsledek";
        sb.append(String.format("%-5s%-15s%-20s%-20s%n", num, t, s, v));
        for (Result result : results) {
            sb.append(String.format("%-10d %s%n", n, result));
            n++;
        }
        return sb.toString();
        //Collections.sort(results, new ComparatorByCorrectness());
    }

    public String sortById() {
        Collections.sort(idQuestions);
        StringBuilder sb = new StringBuilder();
        for (Question question : idQuestions) {
            sb.append(question);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void saveResult(String resultFilepath) throws IOException {
        Writer w;
        if (resultFilepath.endsWith(".txt")) {
            w = new TextWriter();
        } else if (resultFilepath.endsWith(".dat")) {
            w = new BinaryWriter();
        } else {
            throw new IllegalArgumentException("Nepodporovaná připona souboru");
        }
        w.saveResults(resultFilepath, results);
    }

//    public boolean getChoice(String number){
//        if(number == "A" || number == "B" || number == "C" ){
//            return true;
//        }else{
//            return false;
//        }
//    }
}
