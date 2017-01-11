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
        BadConsequence numBC;
        
        int copyNVisibleTreasures = nVisibleTreasures;
        int copyNHiddenTreasures = nHiddenTreasures;

        if (copyNVisibleTreasures > v.size())
        {
            copyNVisibleTreasures = v.size();
        }

        if (copyNHiddenTreasures > h.size())
        {
            copyNHiddenTreasures = h.size();
        }

        numBC = new NumericBadConsequence(this.getText(), this.getLevels(), copyNVisibleTreasures, copyNHiddenTreasures);
        
        return numBC;
    }
   
    
    @Override
    public String toString()
    {   
        return "nVisibleTreasures: " + nVisibleTreasures 
                + "\nnHiddenTreasures" + nHiddenTreasures;
    }
}
