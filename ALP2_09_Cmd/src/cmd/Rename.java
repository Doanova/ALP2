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
public class Rename extends Command {

    @Override
    public String execute(File actualDir) {
        
        if(params.length == 3){
            File oldName = new File(params[1]);
            File newName = new File(params[2]);
            if(oldName.exists() && !newName.exists()){
                try{
                    oldName.renameTo(newName);
                }catch(Exception e){
                    throw new RuntimeException("Nepodarilo se soubor prejmenovat");
                }
            }
        }
        return "Sobor přejmenován";
    }
    
}
