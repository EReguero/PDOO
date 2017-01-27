/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package NapakalakiGame;

import java.util.ArrayList;


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
        SpecificBadConsequence sbc = null;
        ArrayList<TreasureKind> vEliminar = new ArrayList<>();
        ArrayList<TreasureKind> hEliminar = new ArrayList<>();
        for (Treasure treasure: v) {
            if(this.specificVisibleTreasures.indexOf(treasure.getType()) != -1){
                vEliminar.add(treasure.getType());
            }
        }

        for (Treasure treasure: h) {
            if(this.specificHiddenTreasures.indexOf(treasure.getType()) != -1){
                hEliminar.add(treasure.getType());
            }
        }
        
        sbc = new SpecificBadConsequence("", 0, vEliminar, hEliminar);
        return sbc;
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
