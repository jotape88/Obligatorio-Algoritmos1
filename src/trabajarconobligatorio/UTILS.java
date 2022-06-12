/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajarconobligatorio;

import java.util.Random;

/**
 *
 * @author mauro
 */
public class UTILS {

    static String randomColor() {
        Random rand = new Random();
        return "\u001B[3" + rand.nextInt(7) + "m ";
    }
}
