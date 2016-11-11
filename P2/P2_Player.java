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


public class Player {
    final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal= true;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    
    
    public Player(String name){
        
    }
    
    public String getName(){
        return name;
    }
   
    private void bringToLife(){
        dead = false;
        level = 1;
    }
    
    private int getCombatLevel(){
        //coger los tesoros visibles cuando llegues a 10 has ganado.
        //usar el for
        int bonus = 0;
        for(Treasure vt: visibleTreasures)
           bonus =  vt.getBonus() + bonus;
     
              
        return level+bonus;
    }
    
    private void incrementLevels(int l){
        //que no suba de 10 niveles
        level = level + l;
        if(level > 10)
            level = 10;
    }
    
    private void decrementLevels(int l){
        //no podemos bajar de uno con maxlevels
        level = level - l;
        if(level < 1)
            level = 1;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        //modficador basico badconsequence
    }
    
    private void applyPrize(Monster m) {
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        //for con un contador
        int cuentaVisibles = 0;
        for(Treasure vt: visibleTreasures)
            cuentaVisibles++;
        return cuentaVisibles;
        
    }
    
    private void dieIfNoTreasures(){
        //dead = true
        
    }
    
    
    public boolean isDead(){
        return dead;
        
    }
    
    public ArrayList<Treasure> getHiddenTreasures() {
        
    }
    
    
    public ArrayList<Treasure> getVisibleTreasures(){
        
    }
    
    public CombatResult combat(Monster m){
        
    }
    
    public void makeTreasureVisible(Treasure t){
        
    }
    
    public void discardVisibleTreasure(Treasure t){
        
    }
    
    public void discardHiddenTreasure(Treasure t){
        
    }
    
    public boolean validState(){
        //si el jugador puede pasar de turno cuando se cumplen esas 2 condiciones
        //su penbadConse está vacio con isEmpty de la clase bad consequence
        //y si el tamaño de hiddentreasures no es mayor que 4.
       //si devuelve false hay que decirle q no puede pasar
        
    }
    
    public void initTreasures(){
        
    }
    
    public int getLevels(){
        
    }
    
    public Treasure stealTreasure(){
        
    }
    
    public void setEnemy(Player enemy){
        
    }
    
    private Treasure giveMeATreasure(){
        
    }
    
    public boolean canISteal(){
        //consultor básico hay que decir si ùede o no robar
    }
    
    private boolean canYouGiveMeATreasure(){
        //comprueba si el array de tesoros esta vacio o no (negacion de isempty)
    }
    
    private void haveStolen(){
        //cambia el valor de canISteal lo pone a false
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        
    }
    
    
}
