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
public class Exit extends Command {

    @Override
    public String execute(File actualDir) {
        if (params.length == 1) {
            CmdEditor.setIsRunning(false);
            return "konec";
        }
        return "Program se nepovedlo ukončit";
    }

}
