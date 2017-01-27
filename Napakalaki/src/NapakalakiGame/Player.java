/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;


public class Player {
    
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private BadConsequence pendingBadConsequence = new NumericBadConsequence("",0, 0, 0);
    protected Player enemy;
    
    //Constructor
    public Player(String name){
        this.name = name;
        this.level = 1;
    }
    
    //Constructor de Copia
    public Player(Player p){
        this.name = p.getName();
        this.level = p.getLevels();
        this.dead = p.isDead();
        this.canISteal = p.canISteal();
        this.enemy = p.enemy;
        this.visibleTreasures = p.getVisibleTreasures();
        this.hiddenTreasures = p.getHiddenTreasures();
        this.setPendingBadConsequence(p.getPendingBadConsequence());
        
    }
    
    public String getName(){    
        return name;
    }
    
    public BadConsequence getPendingBadConsequence(){
        return this.pendingBadConsequence;
    }
    private void bringToLife(){
        dead = false;
        level = 1;
    }
    
    public int getCombatLevel(){
        
        int bonus = 0;
        for(Treasure t : visibleTreasures)
           bonus = bonus + t.getBonus();
            
        return (level+bonus);
    }
    
    private void incrementLevels(int i){
        this.level = level + i;
    }
    
    private void decrementLevels(int i){
        this.level = level - i;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        
        int nLevels = m.getLevelsGained();
        this.incrementLevels(nLevels);
        
        int nTreasures = m.getTreasuresGained();
        if(nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            for(int i=1; i <= nTreasures; i++){
                Treasure t = dealer.nextTreasure();
                hiddenTreasures.add(t);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        this.decrementLevels(nLevels);
        if(level < 0){
            level = 0;
        }
        BadConsequence pendingBad ;
        pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures);
        
        this.setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        TreasureKind type = t.getType();
        boolean canMakeVisible = true;
        
        switch (type) {
            case ONEHAND:
                if(this.howManyVisibleTreasures(TreasureKind.BOTHHANDS)>0
                        || this.howManyVisibleTreasures(TreasureKind.ONEHAND) >1)
                    canMakeVisible = false;
                break;
            case BOTHHANDS:
                if(this.howManyVisibleTreasures(TreasureKind.BOTHHANDS)>0 ||
                        this.howManyVisibleTreasures(TreasureKind.ONEHAND) > 0)
                    canMakeVisible = false;
                break;
            default:
                if(this.howManyVisibleTreasures(type)>0)
                    canMakeVisible = false;
                break;
        }
        
        return canMakeVisible;
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
        
        int myLevel = this.getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        
        if(!this.canISteal()){
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber();
            if(number < 3){
                int enemyLevel =  this.enemy.getCombatLevel();
                monsterLevel = enemyLevel + monsterLevel;
            }
        }
       
        CombatResult combatResult;
        
        if(myLevel > monsterLevel){
            this.applyPrize(m);
            if(this.level >= MAXLEVEL)
                combatResult = CombatResult.WINGAME;
            else
                combatResult = CombatResult.WIN;
        }
        else{
            this.applyBadConsequence(m);
            if(shouldConvert())
                combatResult = CombatResult.LOSEANDCONVERT;
            else
                combatResult = CombatResult.LOSE;
        }
        
        return combatResult;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = this.canMakeTreasureVisible(t);
        if(canI){
            this.visibleTreasures.add(t);
            this.hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if(pendingBadConsequence != null || !pendingBadConsequence.isEmpty())
            this.pendingBadConsequence.substractVisibleTreasure(t);
        this.dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if(pendingBadConsequence != null || !pendingBadConsequence.isEmpty())
            this.pendingBadConsequence.substractHiddenTreasure(t);
        this.dieIfNoTreasures();
    }
    
    public boolean validState(){
        
      return this.pendingBadConsequence != null || pendingBadConsequence.isEmpty() 
               && hiddenTreasures.size() <= 4;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        this.bringToLife();
        Treasure t = dealer.nextTreasure();
        this.hiddenTreasures.add(t);
        
        int number = dice.nextNumber();
        
        if(number > 1){
            t = dealer.nextTreasure();
            this.hiddenTreasures.add(t);
            
            if(number == 6){
                t = dealer.nextTreasure();
                this.hiddenTreasures.add(t);
            }
        }
       
    }
    
    public int getLevels(){
        return this.level;
    }
    
    public Player getEnemy(){
        return this.enemy;
    }
    
    
    
    protected int getOpponentLevel(Monster m){
        return m.getCombatLevel();
    } 
    public Treasure stealTreasure(){
        
        Treasure t = null;
        boolean canI = this.canISteal();
       
        if(canI){
            boolean canYou = this.canYouGiveMeATreasure();
           
            if (canYou){
                t = this.giveMeATreasure();
                hiddenTreasures.add(t);
                this.haveStolen();
            }
        }
        
        return t;
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    public Treasure giveMeATreasure(){
        Random rand = new Random();
        int n = rand.nextInt(hiddenTreasures.size());
        Treasure t = hiddenTreasures.get(n); 
        hiddenTreasures.remove(n);
        
        return  t;
    }
    
    public boolean canISteal(){
        return this.canISteal;
    }
    
    protected boolean canYouGiveMeATreasure(){
        boolean canSteal = true;
        if(this.hiddenTreasures.isEmpty())
            canSteal = false;
        
        return canSteal;
    }
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        boolean shouldConvert = false;
        int n = dice.nextNumber();
        
        if(n == 6)
            shouldConvert = true;
        
        return shouldConvert;
    }
    private void haveStolen(){
        this.canISteal = false;
    }
    
    public void discardAllTreasures(){
        
        ArrayList<Treasure> copyVisibleTreasures = new ArrayList<>(visibleTreasures);
        ArrayList<Treasure> copyHiddenTreasures = new ArrayList<>(hiddenTreasures);
       
        for(Treasure t : copyVisibleTreasures){
            this.discardVisibleTreasure(t);
        }
        
        for(Treasure t : copyHiddenTreasures){
            this.discardHiddenTreasure(t);
        }
    }
    
     @Override
    public String toString(){
        return (name + ", nivel de "+name+": "+ level);
    }
}

