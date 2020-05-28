/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition.filehandling;

import competition.app.Runner;
import competition.filehandling.Writer;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author helen
 */
public class BinaryWriter extends Writer {

    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFilepath))){
            dos.writeUTF("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                dos.writeInt(n);
                dos.writeChar('.');
                dos.writeUTF(runner.getFirstname());
                int nChars = runner.getLastname().length();
                dos.writeInt(nChars);
                for (int i = 0; i < nChars; i++) {
                    dos.writeChar(runner.getLastname().charAt(i));
                }
                dos.writeLong(runner.runningTime().toNanoOfDay());
                n++;
            }           
        }
    }
    
}
