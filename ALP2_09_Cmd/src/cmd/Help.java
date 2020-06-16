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
public class Help extends Command{

    @Override
    public String execute(File actualDir) {
        String help = "HELP\n" + String.format("%-27s %s\n", "help", "Display help") 
                               + String.format("%-27s %s\n", "dir", "Display list of files and folders") 
                               + String.format("%-27s %s\n", "dir [-o]", "Display an ordered list of files and folders")
                               + String.format("%-27s %s%n", "dir [-e] [file extension]", "Display a list of files and folders with a specified extension------NE")
                               + String.format("%-27s %s%n", "dir [-s] [size]", "Display a list of files and folders bigger than a specified size-------NE")
                               + String.format("%-27s %s\n", "cd [folder name]", "Change directory - move to a specific folder--------NE") 
                               + String.format("%-27s %s\n", "cd ..", "Change directory - move to the folder one level higher")
                               + String.format("%-27s %s\n", "mkdir [folder name]", "Create new folders")
                               + String.format("%-27s %s\n", "rename [nameFrom] [nameTo]", "Display help")
                               + String.format("%-27s %s\n", "tree", "Display tree of files")
                               + String.format("%-27s %s\n", "exit", "Exit cmd");
        return help;
    }
    
}
