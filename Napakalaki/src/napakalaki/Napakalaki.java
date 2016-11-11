/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package napakalaki;

import java.util.ArrayList;


public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer = CardDealer.getInstance();  
    
    private Napakalaki(){
    }
    
    private void InitPlayers(ArrayList<String> names){
        
    }
    
    private Player nextPlayer(){
        
    }
    
    private boolean nextTurnAllowed(){
        
    }
    
    private void setEnemies(){
        
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
        
    }
    
    public void discardVisibleTreasures (ArrayList<Treasure> treasures){
        
    }
    
    public void discardHiddenTreasures (ArrayList<Treasure> treasures){
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
    }
    
    public void initGame(ArrayList<String> players){
        
    }
    
    public Player getCurrentPlayer(){
        
    }
    
    public Monster getCurrentMonster(){
        
    }
    
    public boolean nextTurn(){
        
    }
    
    public boolean endOfGame(CombatResult result){
        
    }
}
