/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/

package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

public class PruebaNapakalaki {
    
    private static ArrayList<Monster>  misMonster = new ArrayList();
   
    public static void main(String[] args) {

      
        for(Monster m : misMonster){
            System.out.print(m.toString());
          
        }
    }
    
}
