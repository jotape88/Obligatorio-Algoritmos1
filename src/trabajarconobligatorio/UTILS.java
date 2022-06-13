/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajarconobligatorio;

import java.util.Random;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 *
 * @author mauro
 */
public class UTILS {

    static String randomColor() {
        Random rand = new Random();
        return "\u001B[3" + rand.nextInt(7) + "m ";
    }
    
    static Date generarFechasRandom(){
        Random rand = new Random();
        GregorianCalendar gc = new GregorianCalendar();
        int year = 2000 + (int)(Math.random()*20);
        int dayOfYear = rand.nextInt(gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR)) + 1;
        gc.set(year, 0, dayOfYear);
        return gc.getTime();   
     }
}
