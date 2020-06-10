/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generazioni;

/**
 *
 * @author feder
 */
public class NumeriRandomici {

    public static int GeneraInt(int floor, int top) {
        if (floor < 0 || (top < floor) || top < 0) {
            return -1;
        }
        int risultato =  (int) (Math.random() * top);        
        if(risultato < floor){
            return GeneraInt(floor, top);
        }
        return risultato;
    }

}
