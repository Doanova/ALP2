package cmd;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helen
 */
public class Parser {
    
    public static Command parse(String line){
        String[] p = line.split(" +"); // + = mezer muze byt 1 a víc // p[0] dir; p[1] -e p[2] .java
        //TODO osetrit ze je tam prazdny prikaz
        char first = Character.toUpperCase(p[0].charAt(0)); //D
        String name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1);    //cmd.Dir     
        try {
            Class c;
            c = Class.forName(name);                    //
            Command command = (Command) c.newInstance(); //vytvori instanci tridy command
            command.setParams(p);
            return command;
        } catch (Exception e) {
            throw new RuntimeException("Nepodarilo se prikaz naparsovat");
        }
    }
    
}
