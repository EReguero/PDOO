/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package NapakalakiGame;


public class Cultist {
    private String name;
    private int gainedLevels;
    
    Cultist(String name, int levels){
        this.name = name;
        this.gainedLevels = levels;
    }
    
    public int getGainedLevels(){
        return gainedLevels;
    }
}
