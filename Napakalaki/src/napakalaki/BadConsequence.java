/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author emilio
 */
public class BadConsequence {
     
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();

    BadConsequence(String text, int levels, int nVisible, int nHidden){
        
       this.text = text;
       this.levels = levels;
       this.nHiddenTreasures = nHidden;
       this.nVisibleTreasures = nVisible;
       this.death = false;
    }
    
    BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
    }
    
  
    
    
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
    ArrayList<TreasureKind> tHidden){
        
        this.text = text;
        this.levels = levels;
        this.specificHiddenTreasures = new ArrayList(tHidden);
        this.specificVisibleTreasures = new ArrayList(tVisible);
    }
    
    public String getText(){
        return(this.text);
    }
    
    public int getLevels(){
        return(this.levels);
    }
    
    public int getnHiddenTreasures(){
        return(this.nHiddenTreasures);
    }
    
    public int getnVisibleTreasures(){
        return(this.nVisibleTreasures);
    }
    
    public ArrayList<TreasureKind> getHiddenTreasures(){
        return (this.specificHiddenTreasures);
    }
    
    public ArrayList<TreasureKind> getVisibleTreasures(){
        return (this.specificVisibleTreasures);
    }
    public boolean getDeath(){
        return(this.death);
    }
    

    @Override
    public String toString(){
       return 
               "Text = " + text + 
               ", levels = " + Integer.toString(levels) + 
               ", Death = " + Boolean.toString(death) +
               ", nHiddenTreasures = " + Integer.toString(this.nHiddenTreasures) +
               ", nVisibleTreasures = " + Integer.toString(this.nVisibleTreasures);
    } 
}
