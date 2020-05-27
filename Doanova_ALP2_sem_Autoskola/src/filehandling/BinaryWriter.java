/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Result;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author helen
 */
public class BinaryWriter extends Writer{

    @Override
    public void saveResults(String resultFilepath, List<Result> results) throws IOException {
        File resultFile = new File(dataDirectory, resultFilepath);
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFile))){
            dos.writeUTF("Nove vysledky");
            int n = 1;
            for (Result result : results) {
                dos.writeInt(n);
                dos.writeUTF(result.getAnswer());
                dos.writeUTF(result.getCorrectAnswer());
//                int nChars = result.getCorrectAnswer().length(); //simulace writeUTF, uložím počet znaků Stringu až pak String 
//                dos.writeInt(nChars);
//                for (int i = 0; i < nChars; i++) {
//                    dos.writeChar(result.getCorrectAnswer().charAt(i));
//                }
                dos.writeUTF(result.getCorrectnes()); 
                n++;
            }
        }
    }
    
}
