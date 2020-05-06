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
public class Mkdir extends Command {

    @Override
    public String execute(File actualDir) {
        if (params.length == 2) {
            File newFile = new File(params[1]);
            if (!newFile.exists()) {
                try {
                    newFile.mkdir();
                } catch (Exception s) {
                    throw new RuntimeException("Nepodarilo se soubor vytvořit");
                }
            }
        }
        return "Soubor úspěšně vytvořen";
    }

}
