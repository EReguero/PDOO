/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author emilio
 */
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
