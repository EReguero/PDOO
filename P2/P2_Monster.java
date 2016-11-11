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


public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    
    
    
    public Monster (String name, int combatLevel, BadConsequence bc, Prize prize){
        this.name=name;
        this.combatLevel = combatLevel;
        this.bc = bc;
        this.prize=prize;
    }
    
    
    
    public String getName (){
        return(this.name);
    }
    
    public int getCombatLevel(){
        return(this.combatLevel);
    }
    
    public Prize getPrize(){
        return(this.prize);
    }
    
    public BadConsequence getBadConsequence(){
        return(this.bc);
    }
    
    @Override
    public String toString(){
       return "\nName = " + name + 
              ", Level = " + Integer.toString(this.combatLevel) + 
              "\nBadConsequence: " + bc.toString() +
              "\nPrize: " + prize.toString() +"\n";
              
    }
}
/*get LG


*/
