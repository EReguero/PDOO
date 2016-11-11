/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package napakalaki;

import java.util.ArrayList;
import java.util.Random;


public class Dice {
    private static final Dice instance = new Dice();
   
    
    private Dice(){
    }
    
    public static Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        Random rand = new Random();
        //El +1 indica cual es el termino inicial del rango
        return rand.nextInt(6)+1;
    }
            
}
