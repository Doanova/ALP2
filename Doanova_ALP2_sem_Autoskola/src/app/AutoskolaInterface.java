/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

/**
 *
 * @author helen
 */
public interface AutoskolaInterface {
    
    public void loadQ(String fileName) throws FileNotFoundException, IOException;
    
    public void selection();
    
    public String printQuestion(int index);
    
    public Boolean getAnswer(String answer, int index);
    
    public void startMeasureTime();
    
    public void endtMeasureTime();
    
    public Duration totalTime();
    
    public String getResults();
    
    public String sortByCorrectness();
    
    public String sortById();
    
    public void saveResult(String resultFilepath) throws IOException;
    
    public boolean chceckEmail(String email);
    
}


