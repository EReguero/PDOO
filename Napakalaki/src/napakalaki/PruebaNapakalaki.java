
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
        
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);  
        Prize prize = new Prize(4,2);
        misMonster.add(new Monster("El rey de rosa", 13, badConsequence, prize));

        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta" 
                + " y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
   
        prize = new Prize(4,1);
        misMonster.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence,prize));

        
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
    }
}
