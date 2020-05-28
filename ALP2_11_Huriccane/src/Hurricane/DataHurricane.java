/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author helen
 */
public class DataHurricane implements HurricaneInterface{

    ArrayList<Hurricane> hurricanes = new ArrayList<>();

    @Override
    public void load() throws FileNotFoundException, IOException {
        File hData = new File("hurricanedata.txt");
        Scanner load = new Scanner(hData);
        while (load.hasNext()) {
            int year = load.nextInt();
            String month = load.next();
            int pressure = load.nextInt();
            int speed = load.nextInt();
            String name = load.next();
            Hurricane h = new Hurricane(year, month, pressure, speed, name);
            hurricanes.add(h);
        }
    }

    @Override
    public String hurricanesPeriod(int y1, int y2) {
        StringBuilder sb = new StringBuilder("");
        for (Hurricane h : hurricanes) {
            if (h.getYear() >= y1 && h.getYear() <= y2) {
                sb.append(h);
                sb.append("\n");
            }
        }
        return sb.toString();

    }

    @Override
    public String hurricaneByName(String name) {
        for (Hurricane h : hurricanes) {
            if (h.getName().equals(name)) {
                return "category: " + h.getCategory() + " speed: " + h.getSpeedInKmh() + "km/h";
            }
        }
        return "Hurikán nenalezen";
    }

    @Override
    public String hurricaneBySpeed() {
        Collections.sort(hurricanes, Comparator.comparing(Hurricane::getSpeedInKmh));
        StringBuilder sb = new StringBuilder();
        for (Hurricane h : hurricanes) {
            sb.append(h.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
