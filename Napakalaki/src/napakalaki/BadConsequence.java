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
        TreasureKind type = t.getType();
        this.specificVisibleTreasures.remove(type);
    }
    
    public void substractHiddenTreasure(Treasure t){
        TreasureKind type = t.getType();
        this.specificHiddenTreasures.remove(type);
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
        this.levels = Player.MAXLEVEL;
        this.nHiddenTreasures = MAXTREASURES;
        this.nVisibleTreasures = MAXTREASURES;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }
    
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        BadConsequence bc;
        
        //Tipo numerico
        if(this.nHiddenTreasures > 0 && this.nVisibleTreasures > 0){
           int nHidden = h.size();
           int nVisible = v.size();
           
           nHidden = Integer.min(nHidden, nHiddenTreasures);
           nVisible = Integer.min(nVisible, nVisibleTreasures);
           
           bc = new BadConsequence(text,levels,nHidden,nVisible);
           
       }
       else{ 
            ArrayList<TreasureKind> specificVTreasures = new ArrayList();
            ArrayList<TreasureKind> specificHTreasures = new ArrayList();
            
            for(Treasure t: v){
              specificVTreasures.add(t.getType());
            }
          
            for(Treasure t : h){
                specificHTreasures.add(t.getType());
            }
            
            specificVTreasures = commonTreasures(this.specificVisibleTreasures,specificVTreasures);
            specificHTreasures = commonTreasures(this.specificHiddenTreasures,specificHTreasures);
           
            bc = new BadConsequence(text,levels,specificVTreasures,specificHTreasures);
       }
        return bc;  
    }   
    
    private ArrayList<TreasureKind> commonTreasures(ArrayList<TreasureKind> bc, ArrayList<TreasureKind> player){
        
        ArrayList<TreasureKind> result = new ArrayList();
        
        for(TreasureKind type : this.specificVisibleTreasures){
           
        }
        
        return result;
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
