/*
* PDOO Practicas - Napakalaki Java
* @author Emilio Reguero y Dunia Rodríguez 
*/
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultists;
    
    private CardDealer(){
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        
        unusedTreasures.add(new Treasure("A prueba de babas",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Ametralladora ACME",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Botas de investigacion",3,TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Botas de lluvia acida",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT",1,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Casco minero",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Escopeta de 3 caniones",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Fez alopodo",3,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Gaita",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato mistico",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Hacha prehistorica",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Insecticida",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica",2,TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos",3,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-comicon",1,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-gnomicon",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycon",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicon",5,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrotelecom",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Porra preternatural",2,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador",1,TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega",2,TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("¡Si mi amo!",4,TreasureKind.HELMET));
        shuffleTreasures();
        
    }
    private void initMonsterCardDeck(){
       
       this.unusedMonsters = new ArrayList();
       this.usedMonsters = new ArrayList();
       
       BadConsequence bc;
       Prize prize;
       ArrayList<TreasureKind> tVisible;
       ArrayList<TreasureKind> tHidden;

        //Creación de "3 Byakhees de bonanza"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ARMOR);
        tHidden = new ArrayList();
        tHidden.add(TreasureKind.ARMOR); 
        bc = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta " , 0, tVisible, tHidden);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bc,prize));

        //Creación de "Tenochtitlan"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.HELMET);
        tHidden = new ArrayList();
        bc = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible ", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Tenochtitlan", 2, bc, prize));
           
        //Creación de "El sopor de Dunwich"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.SHOES);
        tHidden = new ArrayList();
        bc = new SpecificBadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible ", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bc, prize));
        
        //Creación de "Demonios de Magaluf"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ONEHAND);
        tHidden = new ArrayList();
        tHidden.add(TreasureKind.ONEHAND); 
        bc = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo."
                + "Descarta 1 mano visible y 1 mano oculta. ", 0, tVisible, tHidden);
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Demonios de Magaluf",2, bc, prize));
        
        //Creación de  "El gorrón en el umbral"
        bc = new NumericBadConsequence("Pierdes todos tus tesoros visibles. ", 0,BadConsequence.MAXTREASURES, 0);
        prize= new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorron en el umbral", 13, bc, prize));

        //Creación de  "H.P. Munchcraft"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ARMOR);
        tHidden = new ArrayList();
        bc = new SpecificBadConsequence("Pierdes la armadura visible.", 0, tVisible, tHidden);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bc, prize));
            
        //Creación de "Necrófago"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ARMOR);
        tHidden = new ArrayList();
        bc = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible ", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Necrofago", 13, bc, prize));

        //Creación de "El rey de rosado"
        bc = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles. ", 5, 3, 0 );
        prize = new Prize(3,2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, bc, prize));
       
        //Creación de "Flecher"
        bc = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles. ", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Flecher", 2, bc, prize));
        
        //Creación de "Los hondos"
        bc = new DeathBadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente. Estás muerto", true);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, bc, prize));
        
        //Creación de "Semillas Cthulhu"
        bc = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos. ", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bc, prize));

        //Creación de "Dameargo"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.ONEHAND);
        tHidden = new ArrayList();
        bc = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible. ", 0, tVisible, tHidden);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, bc, prize));

        //Creación de "Pollipolipo volante"
        bc = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles. ",3,0,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Pollipolipo volante",3,bc,prize)); 


        //Creación de "YskhtihyssgGoth"
        bc = new DeathBadConsequence("No le hace gracia que "+
                "pronuncien mal su nombre. Estas muerto. ",true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg Goth",14,bc,prize)); 

     
        //Creación de "Familia feliz"
        bc = new DeathBadConsequence("La familia te atrapa. Estás muerto. ", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, bc, prize));
          
        //Creación de "Roboggoth"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.BOTHHANDS);
        tHidden = new ArrayList();
        bc = new SpecificBadConsequence("La quinta directiva" +
        " primaria te obliga a perder 2 niveles y" +
        " un tesoro 2 manos visible. ",2,tVisible,tHidden);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth",8,bc,prize)); 

        //Creación de "El espía sordo"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.HELMET);
        tHidden = new ArrayList();
        bc = new SpecificBadConsequence("Te asusta en la noche. Pierdes un "
                +"casco visible ", 0, tVisible, tHidden);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espia sordo", 5, bc, prize));

        //Creación de "Tongue"
        bc = new NumericBadConsequence("Menudo susto te llevas. " +
        "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Tongue",19,bc,prize)); 
        
        //Creación de "Bícefalo"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.BOTHHANDS);
        tHidden = new ArrayList();
        bc = new NumericBadConsequence("Te faltan manos para tanta cabeza. "
                +"Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Bicefalo",21,bc, prize));
             
        
        //Monstruos Cultist
        //Creación de "El mal decible impronunciable"
        bc = new NumericBadConsequence("Pierdes una mano visible",0,1,0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable",10,bc,prize,-2));
        
        //Creación de "Testigos Oculares"
        bc = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.",0,BadConsequence.MAXTREASURES,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares",6,bc,prize,2));
        
        //Creación de "El gran cthulhu"
        bc = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres",true);
        prize = new Prize(2,5);
        this.unusedMonsters.add(new Monster("El gran cthulhu",20,bc,prize,+4));
        
        //Creación de "Serpiente Politico"
        bc = new NumericBadConsequence("Tu gobierno te recorta dos niveles",2,0,0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente politico",8,bc,prize,-2));
        
        //Creación de "Felpuggoth"
        tVisible = new ArrayList();
        tVisible.add(TreasureKind.HELMET);
        tVisible.add(TreasureKind.ARMOR);
        tHidden = new ArrayList();
        tHidden.add(TreasureKind.BOTHHANDS);
        tHidden.add(TreasureKind.ONEHAND);
        tHidden.add(TreasureKind.ONEHAND);
        bc = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",0,tVisible,tHidden);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth",2,bc,prize,+5));
        
        //Creación de Shoggoth
        bc = new NumericBadConsequence("Pierdes 2 niveles",2,0,0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth",16,bc,prize,-4));
        
        //Creación de Lolitagooth
        bc = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles",2,0,0);
        prize = new Prize(1,1);
        unusedMonsters.add (new Monster("Lolitagooth",2,bc,prize,+3));
        
         
        shuffleMonsters();
    }
    
    private void initCultistsCardDeck(){
       
       unusedCultists = new ArrayList();
        
       unusedCultists.add(new Cultist("Sectario 1",1));
       unusedCultists.add(new Cultist("Sectario 2",2));
       unusedCultists.add(new Cultist("Sectario 3",1));
       unusedCultists.add(new Cultist("Sectario 4",2));
       unusedCultists.add(new Cultist("Sectario 5",1));
       unusedCultists.add(new Cultist("Sectario 6",1));
       
       shuffleCultist();
    }
    
    private void shuffleCultist() {
        Collections.shuffle(this.unusedCultists);
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
        
        if(unusedTreasures.isEmpty()){ 
           unusedTreasures = usedTreasures;
           usedTreasures = new ArrayList();
           shuffleTreasures();
        }
        Treasure next = unusedTreasures.get(0);
        unusedTreasures.remove(0);
        usedTreasures.add(next);
       return next;    
    }

    public Monster nextMonster(){
        
        if(unusedMonsters.isEmpty()){ 
           unusedMonsters = usedMonsters;
           usedMonsters = new ArrayList();
           shuffleMonsters();
        }
        Monster next = unusedMonsters.get(0);
        unusedMonsters.remove(0);
        usedMonsters.add(next);
       return next;
    }
    
   public Cultist nextCultist(){
        Cultist next_cultist = unusedCultists.get(0);
        unusedCultists.remove(next_cultist);
        
        return next_cultist;
   }
    
    public void giveTreasureBack(Treasure t){
        this.usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        this.usedMonsters.add(m);
    }
    
    public void initCards(){
        this.initMonsterCardDeck();
        this.initTreasureCardDeck();
        this.initCultistsCardDeck();
    }
}
