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
public class Tree extends Command{
    
@Override
    public String execute(File actualDir) {
        
        if (params.length == 1) {         
            return treeToString(actualDir,0);
        }
        return null;
    }
    
    

    private String treeToString(File fileDir, int tree) {
        int tre = tree;
        StringBuilder sb = new StringBuilder("");
        File[] files = fileDir.listFiles();
        
        
        
        for (File file : files) {
            if (file.isDirectory()) {
                for(int i = 0; i<=tre; i++){
                sb.append("-");
                }
                sb.append(String.format("%s%n", file.getName()));
                sb.append(treeToString(new File(fileDir.getAbsolutePath()+"\\"+file.getName()),tre+1));
                
            } else {
                for(int i = 0; i<=tre; i++){
                sb.append("-");
                }
                sb.append(String.format("%-30s%n", file.getName()));
            }
        }
        return sb.toString();
    }
}
