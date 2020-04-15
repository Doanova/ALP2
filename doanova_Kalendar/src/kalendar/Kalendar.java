/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalendar;

import java.util.Scanner;

/**
 *
 * @author helen
 */
public class Kalendar {

    private int year;
    private int month;
    private int day;
    static Scanner sc = new Scanner(System.in);

    static int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Kalendar(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //metody
    public int getDayInWeek(int day, int month, int year) {   //zelleruv argoritmus 
        if (month == 1) {
            month = 13;
            year--;
        }
        if (month == 2) {
            month = 14;
            year--;
        }
        int q = day;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;

        return ((h + 5) % 7) + 1;
    }

    public String getKalendar() {
        StringBuilder sb = new StringBuilder();

        sb.append("Date: " + day + "/" + month + "/" + year);
        sb.append("\n");

        sb.append("po ");
        sb.append("út ");
        sb.append("st ");
        sb.append("čt ");
        sb.append("pá ");
        sb.append("so ");
        sb.append("ne ");


        int daysInMonth= daysInMonths[(month)-1];
        if (month == 2 && isLeapYear(year)) {
            daysInMonth = 29;
        }

        sb.append("\n");
        int temp = getDayInWeek(1, month, year);
        for (int i = 1; i < temp; i++) {
            sb.append("   ");
        }
        for (int i = 1; i <= daysInMonth; i++) {
            if (i < 10) {
                sb.append(i + "  ");
            } else {
                sb.append(i + " ");
            }
            if (getDayInWeek(i, month, year) == 7) {
                sb.append("\n");
            }
        }
        sb.append("\n");
        String s = sb.toString();
        return s;
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    public void nextMonth() {
        this.day = 1;

        if (this.month == 12) {
            this.month = 1;
            this.year += 1;
        } else {
            this.month += 1;
        }
    }
    
    public void prevMonth(){
        this.day = 1;

        if (this.month == 1) {
            this.month = 12;
            this.year -= 1;
        } else {
            this.month -= 1;
        }
    }
    
    public static int getDaysOf(int year){
        if(isLeapYear(year)){
            return 366;
        }
        return 355;
    }

    public static void main(String[] args) {
        System.out.println("Zadej den, měsíc, rok: ");
//        int day = sc.nextInt();
//        int month = sc.nextInt();
//        int year = sc.nextInt();
        Kalendar k = new Kalendar(15, 4, 2020);
        //Kalendar k = new Kalendar(day, month, year);
        System.out.println(k.getKalendar());

        System.out.println("Dalsi mesíc = 1 , predesli mesic = -1");
        int choice = sc.nextInt();
        if(choice == 1){
            k.nextMonth();
            System.out.println(k.getKalendar());
        }else{
            k.prevMonth();
            System.out.println(k.getKalendar());
        }
        System.out.println("Zadej rok: ");
        int r = sc.nextInt();
        System.out.println("Rok " + r + " má "+ Kalendar.getDaysOf(r) +" dní");
        if(Kalendar.isLeapYear(r)){
            System.out.println("Tento rok je přestupný");
        }else{
            System.out.println("Tento rok není přestupný");
        }
    }

}
