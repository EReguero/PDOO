/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package napakalaki;

public class Treasure {
    private String name;
    private int bonus;
    private TreasureKind type;
    
    
    public Treasure(String n, int bonus, TreasureKind t){
        this.name = n;
        this.bonus = bonus;
        this.type= t;
    }
    
    String getName(){
        return name;
    }
    
    int getBonus(){
        return bonus;
    }
    
    TreasureKind getType(){
        return type;
    }
}
