/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/

package NapakalakiGame;

import java.util.ArrayList;

public abstract class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    String text;
    int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadConsequence(String text, int level){
        this.text = text;
        levels = level;
    }
    
    public abstract boolean isEmpty();
    
    String getText(){
        return text;
    }
    
    int getLevels(){
        return levels;
    }
    
    public void setLevels(int n) {
        levels = n;
    }  
    public abstract void substractVisibleTreasure(Treasure t);
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
  
    
   
}
