/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package napakalaki;

import java.util.ArrayList;


public class Player {
    
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    private Player enemy;
    
    
    public Player(String name){
        this.name = name;
        this.level = 1;
    }
    
    public String getName(){    
        return name;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    private int getCombatLevel(){
        
        int bonus = 0;
        for(Treasure t : visibleTreasures)
           bonus = bonus + t.getBonus();
            
        return (level+bonus);
    }
    
    private void incrementLevel(int i){
        this.level = level + i;
    }
    
    private void decrementLevel(int i){
        this.level = level - i;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        return true;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        
        int n = 0;
        for(Treasure t : this.visibleTreasures){
           if(t.getType() == tKind)
               n++;
        }
        
        return n;
    }
    
    private void dieIfNoTreasures(){
        if(this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty())
            dead = true;
    }
    
    public boolean isDead(){
        return this.dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
       return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        
    }
    
    public void makeTreasureVisible(Treasure t){
    
    }
    
    public void discardVisibleTreasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
    }
    
    public boolean validState(){
        
        boolean state = false;
        if(this.pendingBadConsequence == null || pendingBadConsequence.IsEmpty() 
                && hiddenTreasures.size() <= 4)
            state = true;
        return state;
    }
    
    public void InitTreasures(){
        
    }
    
    public int getLevels(){
        return this.level;
    }
    
    public Treasure stealTreasure(){
        
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure(){
        
    }
    
    public boolean canISteal(){
        return this.canISteal;
    }
    private boolean canYouGiveMeATreasure(){
        boolean canSteal = true;
        if(this.hiddenTreasures.isEmpty())
            canSteal = false;
        
        return canSteal;
    }
    
    private void haveStolen(){
        this.canISteal = false;
    }
    
    public void discardAllTreasures(){
        
    }
}

