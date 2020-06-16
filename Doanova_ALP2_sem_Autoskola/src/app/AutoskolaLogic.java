package app;

import utils.ComparatorByCorrectness;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author helen
 */
public class AutoskolaLogic implements AutoskolaInterface {

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
    /**
     * zde načítám soubor pomocí bufferedReaderu. Oddělovacá znak je ";"
     * @param fileName - jinymi slovy nameFilpath - cesta k souboru
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void loadQ(String fileName) throws FileNotFoundException, IOException {
        File questFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + fileName);
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
                Question q = new Question(id, question, a, b, c, correct);
                questions.add(q);
            }

        }
    }

    /**
     * Pomocá randomGeneratoru vybírám otázky, které pak přidám do listu s otázkama, které se vypíšou
     */
    public void selection() {                                                   //jmena metod malými písmeny !!!
        for (int i = 0; i < 5; i++) {
            int index = randomGenerator.nextInt(questions.size());
            Question q = questions.get(index);
            selectedQuestions.add(q);
            idQuestions.add(q);
        }
        //return selectedQuestions;
    }

    /**
     * Formátovaně vypíši otazku 
     * @param index
     * @return 
     */
    @Override
    public String printQuestion(int index) {
        StringBuilder sb = new StringBuilder();

        sb.append(selectedQuestions.get(index).getQuestion() + "\n");
        sb.append(selectedQuestions.get(index).getA() + "\n");
        sb.append(selectedQuestions.get(index).getB() + "\n");
        sb.append(selectedQuestions.get(index).getC() + "\n");

        return sb.toString();
    }

    /**
     * Zkontroluji jestli uživatel zadal validní vstup, když ano zapíši si jeho odpověď do results
     * @param answer
     * @param index
     * @return 
     */
    @Override
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

    /**
     * Metoda, která spustí časomíru
     * @return 
     */
    @Override
    public void startMeasureTime() {
        start = Instant.now();
    }
    
    /**
     * Metoda, která ukončí časomíru
     * 
     */
    @Override
    public void endtMeasureTime() {
         end = Instant.now();
    }
    
    /**
     * Metoda, která spočítá celkový čas testu
     * 
     * @return 
     */
    public Duration totalTime() {
        timeElapsed = Duration.between(start, end);
        return timeElapsed;
    }

    /**
     * Formátovaný výpis výsledků
     * @return 
     */
    @Override
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

    /**
     * Formátovaný výpis výsledků podle jejich správnosti
     * @return 
     */
    @Override
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

    /**
     * Formátovaný výpis výsledků seřazených podle jejich origináního id, které je ve vstupním souboru
     * @return 
     */
    @Override
    public String sortById() {
        Collections.sort(idQuestions);
        StringBuilder sb = new StringBuilder();
        for (Question question : idQuestions) {
            sb.append(question);
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Metoda pro uložení výsledků do textového a binárního souboru
     * @param resultFilepath
     * @throws IOException 
     */
    @Override
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
    
    @Override
    public boolean chceckEmail(String email){
        Pattern p = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
        Matcher m = p.matcher(email);
            if (m.find()) {
                //String temp = getEmail(email);
                return true;
            } else {
                return false;
            }
        
    }
    
//    public String getEmail(String email){
//        return email;
//    }

}
