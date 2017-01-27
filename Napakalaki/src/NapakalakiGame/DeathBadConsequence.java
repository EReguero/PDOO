/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package NapakalakiGame;


public class DeathBadConsequence extends NumericBadConsequence {
    
    
    private boolean death;
    
    public DeathBadConsequence (String text, boolean death){
        super(text,Player.MAXLEVEL,MAXTREASURES,MAXTREASURES);
        this.death = death;
    }
    
    @Override
    public boolean isEmpty ()
    {
        return false;
    }
    
    @Override
    public String toString(){
       return "You are dead.";
    }
}
