/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package NapakalakiGame;


public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    private int levelChangeAgainstCultistPlayer = 0;
    
    
    
    public Monster (String name, int combatLevel, BadConsequence bc, Prize prize) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.bc = bc;
    }
    
    public Monster (String name, int combatLevel, BadConsequence bc, Prize prize, int IC){
        this.name = name;
        this.combatLevel = combatLevel;
        this.bc = bc;
        this.prize = prize;
        this.levelChangeAgainstCultistPlayer = IC;
    }
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return (combatLevel+this.levelChangeAgainstCultistPlayer);
    }
    public Prize getPrize(){
        return prize;
    }
    
    public BadConsequence getBadConsequence(){
        return bc;
    }
    
    public int getLevelsGained(){
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
