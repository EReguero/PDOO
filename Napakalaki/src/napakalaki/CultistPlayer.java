/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author emilio
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0;
    Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
    
    public int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    @Override
    protected int getCombatLevel(){
        double combatLevel = super.getCombatLevel() * 1.7;
        combatLevel += myCultistCard.getGainedLevels();
        combatLevel *= totalCultistPlayers;
        
        return (int)combatLevel;
    }
    
    
    @Override
    protected int getOpponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    @Override
    public Treasure giveMeATreasure(){
        Random rand = new Random();
        ArrayList <Treasure> v = super.getVisibleTreasures();
        
        int pos = rand.nextInt(v.size());
        
        Treasure t = v.get(pos);
        v.remove(pos);
        
        return t;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        ArrayList<Treasure> v = super.getVisibleTreasures();
        boolean canYou = !(v.isEmpty());
        
        return canYou;
    }
}
