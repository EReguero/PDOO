/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package napakalaki;

import java.util.ArrayList;
import java.util.Random;


public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList();
    private CardDealer dealer = CardDealer.getInstance();  
    
    private Napakalaki(){
    }
    
    private void initPlayers(ArrayList<String> names){
       
        for(String n : names){
           players.add(new Player(n));
        }
    }
    
    private Player nextPlayer(){
        int n;
        if(currentPlayer == null){
            Random rand = new Random();
            n = (rand.nextInt(players.size()));
        }else{
            n = players.indexOf(currentPlayer)+1;
            //0%2=0 1%2=1 2%2=0... 
            n = n % players.size();
        }
        currentPlayer = players.get(n);
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        boolean allowed = false;
        if(currentPlayer == null || currentPlayer.validState())
           allowed=true;
            
        return allowed;
    }
    
    private void setEnemies(){
        
        Random rand = new Random();
        int pos = 0;
        
        for(Player p : players){
            int n = rand.nextInt(players.size());
            
            while(n == pos)
                n = rand.nextInt(players.size());
            
            p.setEnemy(players.get(n));
            pos = pos + 1;
        }
        
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){ 
       CombatResult combatResult;
       combatResult = this.currentPlayer.combat(currentMonster);
       dealer.giveMonsterBack(currentMonster);
       if(combatResult == CombatResult.LOSEANDCONVERT){
           CardDealer cd = CardDealer.getInstance();
           Cultist c = cd.nextCultist();
           CultistPlayer cp = new CultistPlayer(currentPlayer,c);
           
           
           int pos = players.indexOf(currentPlayer);
           players.add(pos,cp);
           players.remove(pos+1);
           
           for(Player player : players){
               if(player != cp){
                   if(player.enemy == currentPlayer)
                       player.enemy = cp;
               }
           }
           
           currentPlayer = cp;
       }
        
       
       return combatResult;
    }
    
    public void discardVisibleTreasures (ArrayList<Treasure> treasures){
        for(Treasure treasure: treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures (ArrayList<Treasure> treasures){
        for(Treasure treasure: treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure t : treasures){
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        if(stateOK){
            this.currentMonster = dealer.nextMonster();
            this.currentPlayer = this.nextPlayer();
            if(currentPlayer.isDead()){
                this.currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        boolean end = false;
        if(result == CombatResult.WINGAME)
            end = true;
        
        return end;
    }
}
