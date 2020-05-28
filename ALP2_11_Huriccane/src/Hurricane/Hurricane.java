/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hurricane;

/**
 *
 * @author helen
 */
public class Hurricane {
        private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;

    public Hurricane(int year, String month, int pressure, int speed, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }

    public double getSpeedInKmh() {
        return speed * (1.852);
    }

    public int getCategory() {
        double speed = getSpeedInKmh();

        if (speed > 118 && speed < 154) {
            return 1;
        } else if (speed > 153 && speed < 178) {
            return 2;
        } else if (speed > 177 && speed < 209) {
            return 3;
        } else if (speed > 208 && speed < 252) {
            return 4;
        } else if (speed > 251) {
            return 5;
        } else {
            return 0;
        }
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-7s%-5d%-5d%-9s", year, month, pressure, speed, name);
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
