/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author emilio
 */
public class Prize {
  
    private int treasures;
    private int levels;
    
    
    Prize(int treasures, int levels){
        this.treasures= treasures;
        this.levels = levels;
    }

    public int getTreasures(){
        return(this.treasures);
    }
    
    public int getLevels(){
        return(this.treasures);
    }
    
    @Override
    public String toString(){
       return "Treasures = " + Integer.toString(treasures) 
               + ", levels = " + Integer.toString(levels);
    }
}
