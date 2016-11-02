
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PruebaNapakalaki {
    
    private static ArrayList<Monster>  misMonster = new ArrayList();
    
    public static ArrayList<Monster> monstruosNivelCombSupaeriorA(int level){
        
        ArrayList<Monster> resultado = new ArrayList();
        
        for(Monster m : misMonster){
            if(m.getCombatLevel() >= level)
                resultado.add(m);
        }
        
        return resultado;
    }
    
    public static ArrayList<Monster> soloPierdeNiveles(){
        
        ArrayList<Monster> resultado = new ArrayList();
        
        for(Monster m : misMonster){
            
          int  nHiddenTreasures = m.getBadConsequence().getnHiddenTreasures();
          int  nVisibleTreasures = m.getBadConsequence().getnVisibleTreasures();
          int  levels = m.getBadConsequence().getLevels();
          
          if((nHiddenTreasures == 0) && (nVisibleTreasures == 0) && (levels >= 1))
               resultado.add(m);
        }
        
        return resultado;
    }
     
    
    public static ArrayList<Monster> ganarmasde1(){
        
        ArrayList<Monster> resultado = new ArrayList();
        
        for(Monster m : misMonster){
            int level = m.getPrize().getLevels();
            if(level >1)
                resultado.add(m);
        }
        
        return resultado;
    }
    
    public static ArrayList<Monster> perderTesoro(TreasureKind treasure){
        
        ArrayList<Monster> resultado = new ArrayList();
        
        for(Monster m : misMonster){
            ArrayList<TreasureKind> HiddenTreasure = m.getBadConsequence().getHiddenTreasures();
            ArrayList<TreasureKind> VisibleTreasure = m.getBadConsequence().getVisibleTreasures();
        
            for(TreasureKind t : HiddenTreasure){
                if(t == treasure)
                    resultado.add(m);
            }
            for(TreasureKind t : VisibleTreasure){
                if(t == treasure)
                    resultado.add(m);
            }
        }
        
        return resultado;
    }
    
    
    
    public static void main (String [] args){
<<<<<<< HEAD
     
       int opcion = 0;
        
        while(opcion != 5){
            System.out.print("\nElige opcion: \n" +
            "1. Monstruos con nivel de combate superior a X.\n"
            + "2. Monstruos con mal rollo que implique solo perdida de nivel\n"
            + "3. Monstrucos con buen rollo indique una ganancia de niveles superior a 1.\n"
            + "4. Pierdes un determinado tipo de tesoro visible u oculto.\n"
            + "5. Salir.\n");
            
            Scanner in = new Scanner(System.in);
            String entrada = in.nextLine();  //Leer desde teclado
           
            opcion = Integer.parseInt(entrada);
            ArrayList<Monster> resultado = new ArrayList();
            
            switch(opcion) {
                case 1: 
                    System.out.print("Nivel de combate minimo:");
                    entrada = in.nextLine();  //Leer desde teclado
                    int level = Integer.parseInt(entrada);
                    resultado = monstruosNivelCombSupaeriorA(level);
                    break;
                case 2:
                    resultado = soloPierdeNiveles();
                    break;
                case 3:
                    resultado = ganarmasde1();
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.print("Adios.\n");
                    break;
                default: System.out.print("No ha introducido una opcion valida.");
            }

            for(Monster m : resultado){
                System.out.print(m.toString());
            }
       }
=======
       //Creacion de Demonios de Magaluf
        
        BadConsequence bdmagaluf = new BadConsequence("Te atrapan para llevarte de "
                + "fiesta y te dejan caer en mitad del vuelo. Descarta una mano "
                + "visible y otra oculta. ",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));      
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
        

>>>>>>> origin/master
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
        misMonster.add(new Monster("El sopor de Dunwich ", 2, badConsequenceDun, prizeDun));
     
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
        
        //Monstruo --> Pollipolipo volante
        
        BadConsequence bdpollipolipo = new BadConsequence("Da mucho asquito. Pierdes 3 niveles. ",0,1,1);
        Prize prizepollipolipo = new Prize(2,1);
        misMonster.add(new Monster("Pollipólipo volante",3,bdpollipolipo,prizepollipolipo)); 

        
        //Monstruo --> YskhtihyssgGoth
        BadConsequence bdysk = new BadConsequence("No le hace gracia que "+
                "pronuncien mal su nombre. Estas muerto. ",true);
        Prize prizeysk = new Prize(2,1);
        misMonster.add(new Monster("YskhtihyssgGoth",3,bdysk,prizeysk)); 
        
<<<<<<< HEAD
        //Monstruo --> Roboggoth
        BadConsequence bdrobot = new BadConsequence("La quinta directiva" +
        " primaria te obliga a perder 2 niveles y" +
        " un tesoro 2 manos visible. ",2,2,0);
        Prize prizerobot = new Prize(2,1);
        misMonster.add(new Monster("Roboggoth",8,bdrobot,prizerobot)); 
        
        
        //Monstruo --> Tongue
        BadConsequence bdtongue = new BadConsequence("Menudo susto te llevas. " +
        "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
        Prize prizetongue = new Prize(2,1);
        misMonster.add(new Monster("Tongue",19,bdtongue,prizetongue)); 
        
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);  
        Prize prize = new Prize(4,2);
        misMonster.add(new Monster("El rey de rosa", 13, badConsequence, prize));     
=======
        for(Monster m : misMonster){
            System.out.print(m.toString());
        }
        
                
       int opcion = 0;
        
        while(opcion != 5){
            System.out.print("\nElige opcion: \n" +
            "1. Monstruos con nivel de combate superior a X.\n"
            + "2. Monstruos con mal rollo que implique solo perdida de nivel\n"
            + "3. Monstrucos con buen rollo indique una ganancia de niveles superior a 1.\n"
            + "4. Pierdes un determinado tipo de tesoro visible u oculto.\n"
            + "5. Salir.\n");
            
            Scanner in = new Scanner(System.in);
            String entrada = in.nextLine();  //Leer desde teclado
           
            opcion = Integer.parseInt(entrada);
            ArrayList<Monster> resultado = new ArrayList();
            
            switch(opcion) {
                case 1: 
                    System.out.print("Nivel de combate minimo:");
                    entrada = in.nextLine();  //Leer desde teclado
                    int level = Integer.parseInt(entrada);
                    resultado = monstruosNivelCombSupaeriorA(level);
                    break;
                case 2:
                    resultado = soloPierdeNiveles();
                    break;
                case 3:
                    resultado = ganarmasde1();
                    break;
                case 4:
                    ArrayList<Monster> resultado1 = perderTesoro(TreasureKind.ARMOR);
                    ArrayList<Monster> resultado2 = perderTesoro(TreasureKind.ONEHAND);
                    ArrayList<Monster> resultado3 = perderTesoro(TreasureKind.BOTHHANDS);
                    ArrayList<Monster> resultado4 = perderTesoro(TreasureKind.HELMET);
                    ArrayList<Monster> resultado5 = perderTesoro(TreasureKind.SHOES);
                    for(Monster m : resultado1){
                        System.out.print(m.toString());
                    }
                    for(Monster m : resultado2){
                        System.out.print(m.toString());
                    }
                    for(Monster m : resultado3){
                     System.out.print(m.toString());
                       }
                    for(Monster m : resultado4){
                        System.out.print(m.toString());
                    }
                    for(Monster m : resultado5){
                        System.out.print(m.toString());
                    }
                    
                    break;
                case 5:
                    System.out.print("Adios.\n");
                    break;
                default: System.out.print("No ha introducido una opcion valida.");
            }

            for(Monster m : resultado){
                System.out.print(m.toString());
            }
       }
        
       
>>>>>>> origin/master
    }
}
