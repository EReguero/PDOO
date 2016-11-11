/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package NapakalakiGame;
//Esta clase es el dado.

/**
 *
 * @author Dunia
 */


import java.util.Random;


public class Dice {
    private static Dice instance = new Dice();
    //Constructor privado pra asegurarse que no se puede usar el new con el constructor en ningun otro sitio.
    private Dice(){
    }
    public static Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        Random rand = new Random();
        return rand.nextInt(6)+1;
    }
    
}


