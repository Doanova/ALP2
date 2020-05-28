/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Result;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author helen
 */
public class TextWriter extends Writer {
    /**
     * Metoda, která vpisuje data do souboru
     * @param resultFilepath 
     * @param results - list výsledků
     * @throws IOException 
     */

    @Override
    public void saveResults(String resultFilepath, List<Result> results) throws IOException {
        File resultFile = new File(dataDirectory, resultFilepath);
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, true)))) {            
            pw.println("Nove vysledky");
            pw.println("Email uzivatele:");
            int n = 1;
            String num = "č.";
            String t = "Tvá o.";
            String s = "Správná o.";
            String v = "Výsledek";
            pw.print(String.format("%-3s%-15s%-15s%-20s%n", num, t, s, v));
            for (Result result : results) {
                pw.print(n + ". ");
                pw.println(result.toString());
                n++;
            }
        }
    }
}
