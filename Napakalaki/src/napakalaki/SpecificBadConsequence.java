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
public class SpecificBadConsequence extends BadConsequence {
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(text,levels);
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
     public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
     
    public void substractVisibleTreasure(Treasure t){
        TreasureKind type = t.getType();
        this.specificVisibleTreasures.remove(type);
    }
    
    public void substractHiddenTreasure(Treasure t){
        TreasureKind type = t.getType();
        this.specificVisibleTreasures.remove(type);
    }
    
    
    @Override
    public boolean isEmpty ()
    {
        boolean empty = false;
        
        if ((specificHiddenTreasures.isEmpty()) && 
                (specificVisibleTreasures.isEmpty()))
            empty = true;
        
        return empty;
    }
    
     @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,
            ArrayList<Treasure> h)
    {
        BadConsequence specificBC;
        
 
        ArrayList<Treasure> copiaV = new ArrayList(v);
        ArrayList<TreasureKind> newSpecificVisible = new ArrayList();

        for (TreasureKind tk : specificVisibleTreasures)
        {
            int i = 0;
            boolean found = false;

            while ((i < copiaV.size()) && !(found))
            {
                if (copiaV.get(i).getType() == tk)
                {
                    found = true;
                    newSpecificVisible.add(tk);
                    copiaV.remove(i);
                }

                i++;
            }
        }

        // FOR HIDDEN TREASURES
        ArrayList<Treasure> copiaH = new ArrayList(h);
        ArrayList<TreasureKind> newSpecificHidden = new ArrayList();

        for (TreasureKind tk : specificHiddenTreasures)
        {
            int i = 0;
            boolean found = false;

            while ((i < copiaH.size()) && !(found))
            {
                if (copiaH.get(i).getType() == tk)
                {
                    found = true;
                    newSpecificHidden.add(tk);
                    copiaH.remove(i);
                }

                i++;
            }
        }

        specificBC = new SpecificBadConsequence(this.getText(),this.getLevels(),
                newSpecificVisible,newSpecificHidden);
        
        return specificBC;
    }
    
    @Override
    public String toString()
    {   
        String out = "";
       
        if (!specificVisibleTreasures.isEmpty()){
        out = "specificVisibleTreasures: ";
         for (int i = 0; i < specificVisibleTreasures.size(); i++)
                out += specificVisibleTreasures.get(i) + " ";
        }
        if (!specificHiddenTreasures.isEmpty()){
            out = "\nspecificHiddenTreasures: ";
             for (int i = 0; i < specificHiddenTreasures.size(); i++)
                    out += specificHiddenTreasures.get(i) + " ";    
       }  
        
       return out;
    }
}
