/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/

package NapakalakiGame;


public class Prize {
    private int level;
    private int treasures;
    
    
    public Prize(int treasures, int level){
        this.treasures = treasures;
        this.level = level;
    }
    
    
    int getTreasures(){
        return treasures;
    }
    
    int getLevel(){
        return level;
    }
    
    @Override
    public String toString(){
        return ("Treasures = " + Integer.toString(treasures) + " levels = " + Integer.toString(level));
    }
}
