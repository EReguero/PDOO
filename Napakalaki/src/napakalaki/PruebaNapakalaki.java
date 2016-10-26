/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 * @author emilio
 **/
public class PruebaNapakalaki {
    public static void main (String [] args){
        ArrayList<Monster>  misMonster = new ArrayList();

       //Creacion de Demonios de Magaluf
        
        BadConsequence bdmagaluf = new BadConsequence("Te atrapan para llevarte de "
                + "fiesta y te dejan caer en mitad del vuelo. Descarta una mano "
                + "visible y otra oculta. ",0,1,1);      
        Prize prizemagaluf = new Prize(4,1);
        misMonster.add(new Monster("Demonios de Magaluf",2,bdmagaluf,prizemagaluf)); 

        //Creacion de Pollipolipo volante
        
        BadConsequence bdpollipolipo = new BadConsequence("Da mucho asquito. Pierdes 3 niveles. ",0,1,1);
        Prize prizepollipolipo = new Prize(2,1);
        misMonster.add(new Monster("Pollipólipo volante",3,bdpollipolipo,prizepollipolipo)); 

        
        //Creacion de YskhtihyssgGoth
        BadConsequence bdysk = new BadConsequence("No le hace gracia que "+
                "pronuncien mal su nombre. Estas muerto. ",true);
        Prize prizeysk = new Prize(2,1);
        misMonster.add(new Monster("YskhtihyssgGoth",3,bdysk,prizeysk)); 
        
        //Creacion de Roboggoth
        BadConsequence bdrobot = new BadConsequence("La quinta directiva" +
        " primaria te obliga a perder 2 niveles y" +
        " un tesoro 2 manos visible. ",2,2,0);
        Prize prizerobot = new Prize(2,1);
        misMonster.add(new Monster("Roboggoth",8,bdrobot,prizerobot)); 
        
        
        //Creacion de Tongue
        BadConsequence bdtongue = new BadConsequence("Menudo susto te llevas. " +
        "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
        Prize prizetongue = new Prize(2,1);
        misMonster.add(new Monster("Tongue",19,bdtongue,prizetongue)); 
        
         //Monstruo  --> El rey de rosa
        
        Prize prizeERDR = new Prize(4, 2);
        BadConsequence badConsequenceERDR = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles. ", 5, 3, 0 );
        misMonster.add(new Monster("El rey de rosa ", 13, badConsequenceERDR, prizeERDR));
        
         //Monstruo  -->  Ángeles de la noche ibizenca
        
        Prize prizeANI = new Prize(4, 1);
        BadConsequence badConsequenceANI = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo."
                + "Descarta una mano visible y una mano oculta. ", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        misMonster.add(new Monster("Ángeles de la noche ibizenca ", 14, badConsequenceANI, prizeANI));
        
        //Monstruo  -->  3 Byakhees de bonanza
        
        Prize prize3Bya = new Prize(2, 1);
        BadConsequence badConsequence3Bya = new BadConsequence("Pierdes tu armadura visible y otra oculta " , 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        misMonster.add(new Monster("3 Byakhees de bonanza ", 8, badConsequence3Bya, prize3Bya)); 
        
        
         //Monstruo  -->  Tenochtitlan
        
        Prize prizeTeno = new Prize(1, 1);
        BadConsequence badConsequenceTeno = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible ", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        misMonster.add(new Monster("Tenochtitlan ", 2, badConsequenceTeno, prizeTeno));
        
        
         //Monstruo  -->  El sopor de Dunwich
        
        Prize prizeDun = new Prize(1, 1);
        BadConsequence badConsequenceDun = new BadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible ", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        misMonster.add(new Monster("Ángeles de la noche ibizenca ", 2, badConsequenceDun, prizeDun));
     
         //Monstruo  -->  El gorrón en el umbral
        
        Prize prizeGorr = new Prize(3, 1);
        BadConsequence badConsequenceGorr = new BadConsequence("Pierdes todos tus tesoros visibles. ", 0, Integer.MAX_VALUE , 0);
        misMonster.add(new Monster("El gorrón en el umbral ", 13, badConsequenceGorr, prizeGorr));
        
        
         //Monstruo  -->  H.P. Munchcraft
        
        Prize prizeHP = new Prize(2, 1);
        BadConsequence badConsequenceHP = new BadConsequence("Pierdes la armadura visible ", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR )),new ArrayList() );
        misMonster.add(new Monster("El gorrón en el umbral ", 6, badConsequenceHP, prizeHP));
        
         //Monstruo  -->  Necrófago
        
        Prize prizeNec = new Prize(1, 1);
        BadConsequence badConsequenceNec = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible ", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR )) ,new ArrayList() );
        misMonster.add(new Monster("Necrófago ", 13, badConsequenceNec, prizeNec));
        
        //Monstruo  -->  El rey de rosado
        
        Prize prizeRosado = new Prize(3, 2);
        BadConsequence badConsequenceRosado = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles ", 5, 3 , 0);
        misMonster.add(new Monster("El rey de rosado", 11, badConsequenceRosado, prizeRosado));
        
        //Monstruo  -->  Flecher
        
        Prize prizeFle = new Prize(1, 1);
        BadConsequence badConsequenceFle = new BadConsequence("Toses los pulmones y pierdes 2 niveles. ", 2, 0, 0);
        misMonster.add(new Monster("Flecher", 2, badConsequenceFle, prizeFle));
        
        
        //Monstruo  -->  Los hondos
        
        Prize prizeLosH = new Prize(2, 1);
        BadConsequence badConsequenceLosH = new BadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente. Estás muerto", true);
        misMonster.add(new Monster("Los Hondos ", 8, badConsequenceLosH, prizeLosH));
        
        
        //Monstruo  -->  Semillas Cthulhu
        
        Prize prizeSem = new Prize(2, 1);
        BadConsequence badConsequenceSem = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos. ", 2, 0, 2);
        misMonster.add(new Monster("Semillas Cthulhu ", 4, badConsequenceSem, prizeSem));
        
        
        //Monstruo  -->  Dameargo
        
        Prize prizeDam = new Prize(2, 1);
        BadConsequence badConsequenceDam = new BadConsequence("Te intentas escaquear. Pierdes una mano visible. ", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND )), new ArrayList());
        misMonster.add(new Monster("Dameargo ", 1, badConsequenceDam, prizeDam));
        
        //Monstruo  -->  Familia Feliz
        
        Prize prizeFam = new Prize(3, 1);
        BadConsequence badConsequenceFam = new BadConsequence("La familia te atrapa. Estás muerto. ", true);
        misMonster.add(new Monster("Familia Feliz ", 1, badConsequenceFam, prizeFam));
        
        //Monstruo  -->  El espía sordo
        
        Prize prizeEsp = new Prize(1, 1);
        BadConsequence badConsequenceEsp = new BadConsequence("Te asusta en la noche. Pierdes un "
                +"casco visible ", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        misMonster.add(new Monster("El espía sordo ", 5, badConsequenceEsp, prizeEsp));
        
        //Monstruo  -->  Bicéfalo
        
        Prize prizeBi = new Prize(2, 1);
        BadConsequence badConsequenceBi = new BadConsequence("Te faltan manos para tanta cabeza. "
                +"Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, Integer.MAX_VALUE , 0);
        misMonster.add(new Monster("Bicéfalo ", 21, badConsequenceBi, prizeBi));
        
        
        
        for(Monster m : misMonster){
            System.out.print(m.toString());
        }
    }
}
