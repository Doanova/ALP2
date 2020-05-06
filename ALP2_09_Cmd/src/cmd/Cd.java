/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author helen
 */
public class Cd extends Command{

    @Override
    public String execute(File actualDir) {
        
        //TODO -- dodelat
        //String path = params[1].getAbsolutePath();
        //File f = path.getAbsoluteFile();
        //System.out.println(path);
        if(params.length == 2 && !params[1].equals("..")){
            System.out.println("lalala");
            //File path = new File(params[1]);

               // CmdEditor.changeActualDir(f);
                return "Složka změněna";

        }else if(params.length == 2 && params[1].equals("..")){
            File higherFile = actualDir.getParentFile();
            CmdEditor.setActualDir(higherFile);
            return "Složka změněna";
        }
        return "Nepodařilo se změnit složku";
    }
    
}
