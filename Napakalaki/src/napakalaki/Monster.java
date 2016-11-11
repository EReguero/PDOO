/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package napakalaki;


public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    
    
    
    public Monster (String name, int combatLevel, BadConsequence bc, Prize prize) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.bc = bc;
    }
    
    String getName(){
        return name;
    }
    
    int getCombatLevel(){
        return combatLevel;
    }
    
    Prize getPrize(){
        return prize;
    }
    
    BadConsequence getBadConsequence(){
        return bc;
    }
    
    public int getlevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
   @Override
   public String toString(){
       return("\nName = " + name + ", CombatLevel: " + combatLevel + 
               ".\nPrize: " + prize + "\nBadConsequence: " + bc +".\n");
   }
}
