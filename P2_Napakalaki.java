/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Dunia
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Napakalaki {
    
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    
    
    private static Napakalaki instance = new Napakalaki();
    //Constructor privado pra asegurarse que no se puede usar el new con el constructor en ningun otro sitio.
    private Napakalaki(){
    }
    public static Napakalaki getInstance(){
        return instance;
    }
    
    private Player nextPlayer(){
        
    }
    
    private boolean nextTurnAllowed(){
        
    }
    
    private void setEnemies(){
    
    }
    
    public CombatResult developCombat(){
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
    }
    
    public void initGame(String players){
        
    }
    
    public Player getCurrentPlayer(){
        
    }
    
    public Monster getCurrentMonster(){
        
    }
    
    public boolean nextTurn() {
        
    }
    
    public boolean endOfGame(CombatResult result){
        
    }
    
    
    
    
}
