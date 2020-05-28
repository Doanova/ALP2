/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hurricane;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author helen
 */
public interface HurricaneInterface {
    public void load()throws FileNotFoundException, IOException;
    public String hurricanesPeriod(int y1, int y2);
    public String hurricaneByName(String name);
    public String hurricaneBySpeed();    
}
