/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/

package napakalaki;

import java.util.ArrayList;

public class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    
    public boolean IsEmpty(){
        boolean empty = false;
        
        if(this.levels == 0 && this.nHiddenTreasures == 0 && 
                this.nVisibleTreasures == 0 && this.death == false && 
                this.specificHiddenTreasures.isEmpty() && 
                this.specificVisibleTreasures.isEmpty())
            empty = true;
        return empty;
    }
    
    String getText(){
        return text;
    }
    
    int getLevels(){
        return levels;
    }
    
    int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    ArrayList<TreasureKind> getHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    
    ArrayList<TreasureKind> getVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    boolean getDeath(){
        return death;
    }
    
    public void substractVisibleTreasure(Treasure t){
        
    }
    
    public void substractHiddenTreasure(Treasure t){
        
    }
    
     public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }
    
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
    }
    
    
    @Override
    public String toString(){
        return ("Text = " + text + ", levels = " + Integer.toString(levels) 
                + ", HiddenTreasures = " + Integer.toString(nHiddenTreasures) 
                + ", VisibleTreasures = " + Integer.toString(nVisibleTreasures)
                + ", Death = " + Boolean.toString(death)
                + ", VisibleItems = " + specificVisibleTreasures
                + ", HiddenItems = " + specificHiddenTreasures);
    }
}
