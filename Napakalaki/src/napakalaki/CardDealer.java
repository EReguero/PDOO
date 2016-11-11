/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    private CardDealer(){
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Sí mi amo!",4,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion",3,TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT",1,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicón",1,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón",5,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicón",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycón",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES));
    }
    private void initMonsterCardDeck(){
           
       BadConsequence bd;
       Prize prize;
       ArrayList<TreasureKind> tVisible;
       ArrayList<TreasureKind> tHidden;

        //Creación de "3 Byakhees de bonanza"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ARMOR);
        tHidden = new ArrayList();
        tHidden.add(TreasureKind.ARMOR); 
        bd = new BadConsequence("Pierdes tu armadura visible y otra oculta " , 0, tVisible, tHidden);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza ", 8, bd,prize));

        //Creación de "Tenochtitlan"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.HELMET);
        tHidden = new ArrayList();
        bd = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible ", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Tenochtitlan ", 2, bd, prize));
           
        //Creación de "El sopor de Dunwich"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.SHOES);
        tHidden = new ArrayList();
        bd = new BadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible ", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich ", 2, bd, prize));
        
        //Creación de "Demonios de Magaluf"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ONEHAND);
        tHidden = new ArrayList();
        tHidden.add(TreasureKind.ONEHAND); 
        bd = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo."
                + "Descarta 1 mano visible y 1 mano oculta. ", 0, tVisible, tHidden);
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibizenca ", 14, bd, prize));
        
        //Creación de  "El gorrón en el umbral"
        bd = new BadConsequence("Pierdes todos tus tesoros visibles. ", 0,BadConsequence.MAXTREASURES, 0);
        prize= new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral.", 13, bd, prize));

        //Creación de  "H.P. Munchcraft"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ARMOR);
        tHidden = new ArrayList();
        bd = new BadConsequence("Pierdes la armadura visible.", 0, tVisible, tHidden);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bd, prize));
            
        //Creación de "Necrófago"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ARMOR);
        tHidden = new ArrayList();
        bd = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible ", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Necrófago ", 13, bd, prize));

        //Creación de "El rey de rosado"
        bd = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles. ", 5, 3, 0 );
        prize = new Prize(3,2);
        unusedMonsters.add(new Monster("El rey de rosado", 13, bd, prize));
       
        //Creación de "Flecher"
        bd = new BadConsequence("Toses los pulmones y pierdes 2 niveles. ", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Flecher", 2, bd, prize));
        
        //Creación de "Los hondos"
        bd = new BadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente. Estás muerto", true);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los Hondos ", 8, bd, prize));
        
        //Creación de "Semillas Cthulhu"
        bd = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos. ", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu ", 4, bd, prize));

        //Creación de "Dameargo"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ONEHAND);
        tHidden = new ArrayList();
        bd = new BadConsequence("Te intentas escaquear. Pierdes una mano visible. ", 0, tVisible, tHidden);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo ", 1, bd, prize));

        //Creación de "Pollipolipo volante"
        bd = new BadConsequence("Da mucho asquito. Pierdes 3 niveles. ",3,0,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Pollipólipo volante",3,bd,prize)); 


        //Creación de "YskhtihyssgGoth"
        bd = new BadConsequence("No le hace gracia que "+
                "pronuncien mal su nombre. Estas muerto. ",true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("YskhtihyssgGoth",14,bd,prize)); 

     
        //Creación de "Familia feliz"
        bd = new BadConsequence("La familia te atrapa. Estás muerto. ", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Familia Feliz ", 1, bd, prize));
          
        //Creación de "Roboggoth"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.BOTHHANDS);
        tHidden = new ArrayList();
        bd = new BadConsequence("La quinta directiva" +
        " primaria te obliga a perder 2 niveles y" +
        " un tesoro 2 manos visible. ",2,2,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth",8,bd,prize)); 

        //Creación de "El espía sordo"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.HELMET);
        tHidden = new ArrayList();
        bd = new BadConsequence("Te asusta en la noche. Pierdes un "
                +"casco visible ", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espía sordo ", 5, bd, prize));

        //Creación de "Tongue"
        bd = new BadConsequence("Menudo susto te llevas. " +
        "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Tongue",19,bd,prize)); 
        
        //Creación de "Bícefalo"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.BOTHHANDS);
        tHidden = new ArrayList();
        bd = new BadConsequence("Te faltan manos para tanta cabeza. "
                +"Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, Integer.MAX_VALUE , 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Bicéfalo ",21,bd, prize));
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(this.unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(this.unusedMonsters);
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    
    public Treasure nextTreasure(){
        
    }
    
    public Monster nextMonster(){
        
    }
    
    public void giveTreasureBack(Treasure t){
        this.usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        this.usedMonsters.add(m);
    }
    
    public void initCards(){
    
    }
}
