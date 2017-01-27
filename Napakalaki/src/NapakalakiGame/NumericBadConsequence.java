/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/

package NapakalakiGame;

import java.util.ArrayList;


public class NumericBadConsequence extends BadConsequence{
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
        super(text,levels);
        if(nVisible > MAXTREASURES)
            this.nVisibleTreasures = MAXTREASURES;
        else
            this.nVisibleTreasures = nVisible;
        if(nHidden > MAXTREASURES)
            this.nHiddenTreasures = MAXTREASURES;
        else    
            this.nHiddenTreasures = nHidden;
     
    }
    
    
    public int getNHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    public int getNVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if (nVisibleTreasures > 0)
            nVisibleTreasures--;
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if (nHiddenTreasures > 0)
            nVisibleTreasures--;
    }
    
    @Override
    public boolean isEmpty(){
        boolean empty = false;
        
        if ((nVisibleTreasures == 0) && (nHiddenTreasures == 0))
            empty = true;
        
        return empty;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,
            ArrayList<Treasure> h)
    {
         return (new NumericBadConsequence(text, levels, Math.min(this.nVisibleTreasures, v.size()), Math.min(this.nHiddenTreasures, h.size())));
    }
   
    
    @Override
    public String toString(){
        String response = "";
        
        if(nVisibleTreasures > 0 || nHiddenTreasures > 0)
            response = "Pierdes: Tesoros Visibles: "+nVisibleTreasures+", Tesoros Ocultos: "+nHiddenTreasures;
        
        return response;
    }
}
