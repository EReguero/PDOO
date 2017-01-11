#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative 'bad_consequence.rb'
require_relative 'specific_bad_consequence.rb'
require_relative 'numeric_bad_consequence.rb'
require_relative 'death_bad_consequence.rb'
require_relative 'treasure.rb'
require_relative 'treasure_kind.rb'
require 'singleton'
module NapakalakiGame
class CardDealer
  include Singleton
  @@MAXTREASURES = 10
  def initialize
    @usedMonsters = Array.new
    @unusedMonsters = Array.new
    @usedTreasures = Array.new
    @unusedTreasures = Array.new
    @unusedCultist = Array.new
  end
  
  def nextTreasure()
    if @unusedTreasures.empty?
      @usedTreasures.shuffle!
      
      for i in 0 ..(usedMonsters.size)
        @unusedTreasures[i] = @usedTreasures[i]
      end
      
      @usedTreasures.clear
    end
    sig = @unusedTreasures[0]
    @unusedTreasures.delete(sig)
    @usedTreasures << sig
    
    sig
  end
  
  def nextMonster()
     if @unusedMonsters.empty?
      @usedMonsters.shuffle!
      
      for i in 0 ..(usedMonsters.size)
        @unusedMonsters[i] = @usedMonsters[i]
      end
      
      @usedMonsters.clear
    end
    sig = @unusedMonsters[0]
    @unusedMonsters.delete(sig)
    @usedMonsters << sig
    
    sig
  end
  
  def next_cultist
    sig =  @unusedCultists[0]
    @unusedCultists.delete(sig)
    
    sig
  end
  
  def giveTreasureBack(treasure)
    @usedTreasures << treasure
  end
  
  def giveMonsterBack(monster)
   @usedMonsters << monster
  end
  
  def initCards()
    initTreasureCardDeck
    initMonsterCardDeck
  end
  
  private #Los siguientes métodos son privados
  
  def initTreasureCardDeck()
    @unusedTreasures << Treasure.new("¡Sí mi amo!",4,TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Botas de investigacion",3,TreasureKind::SHOES)
    @unusedTreasures << Treasure.new("Capucha de Cthulhu",3,TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("A prueba de babas",2,TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Botas de lluvia acida",1,TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Casco minero",2,TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Ametralladora ACME",4,TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Camiseta de la ETSIIT",1,TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Clavo de rail ferroviario",3,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Cuchillo de sushi arcano",2,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Fez alópodo",3,TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Hacha prehistorica",2,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("El aparato del Pr. Tesla",4,TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Gaita",4,TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Insecticida",2,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Escopeta de 3 cañones",4,TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Garabato místico",2,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("La rebeca metalica",2,TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Lanzallamas",4,TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Necrocomicón",1,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necronomicón",5,TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Linterna a 2 manos",3,TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Necrognomicón",2,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necrotelecom",2,TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Mazo de los antiguos",3,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necroplayboycón",3,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Porra preternatural",2,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Shogulador",1,TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Varita de atizamiento",3,TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Tentáculo de pega",2,TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Zapato deja-amigos",1,TreasureKind::SHOES)
    
    @unusedTreasures.shuffle!
  end
  
  def initMonsterCardDeck()
    
    #Creación de "Dameargo"
    t_visible = [TreasureKind::ONEHAND]
    t_hidden = []
    bc = SpecificBadConsequence.new("Te intentas escaquear. Pierdes una mano visible. ", 0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Dameargo ", 1, bc, prize,0)
    
    #Creación de "3 Byakhees de bonanza"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = [TreasureKind::ARMOR]
    bc = SpecificBadConsequence.new("Pierdes tu armadura visible y otra oculta ",0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("3 Byakhees de bonanza ", 8, bc,prize,0)

    #Creación de "Tenochtitlan"
    t_visible = [TreasureKind::HELMET]
    t_hidden = []
    bc = SpecificBadConsequence.new("Embobados con el lindo primigenio te descartas de tu casco visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("Tenochtitlan ", 2, bc, prize,0)

    #Creación de "El sopor de Dunwich"
    t_visible = [TreasureKind::SHOES]
    t_hidden = []
    bc = SpecificBadConsequence.new("El primordial bostezo contagioso. " + "Pierdes el calzado visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("El sopor de Dunwich ", 2, bc, prize,0)

    #Creación de "Demonios de Magaluf"
    t_visible = [TreasureKind::ONEHAND]
    t_hidden = [TreasureKind::ONEHAND]
    bc = SpecificBadConsequence.new("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo." + "Descarta 1 mano visible y 1 mano oculta. ", 0, t_visible, t_hidden)
    prize = Prize.new(4, 1)
    @unusedMonsters << Monster.new("Ángeles de la noche ibizenca ", 14, bc, prize,0)

    #Creación de  "El gorrón en el umbral"
    bc = NumericBadConsequence.new("Pierdes todos tus tesoros visibles.",0,11,0)
    prize= Prize.new(3, 1)
    @unusedMonsters << Monster.new("El gorrón en el umbral.", 13, bc, prize,0)

    #Creación de  "H.P. Munchcraft"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = []
    bc = SpecificBadConsequence.new("Pierdes la armadura visible.", 0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("H.P. Munchcraft", 6, bc, prize,0)

    #Creación de "Necrófago"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = []
    bc = SpecificBadConsequence.new("Sientes bichos bajo la ropa. Descarta la armadura visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("Necrófago ", 13, bc, prize,0)

    #Creación de "El rey de rosado"
    bc = NumericBadConsequence.new("Pierdes 5 niveles y 3 tesoros visibles. ", 5, 3, 0)
    prize = Prize.new(3,2)
    @unusedMonsters << Monster.new("El rey de rosado", 13, bc, prize,0)

    #Creación de "Flecher"
      bc = NumericBadConsequence.new("Toses los pulmones y pierdes 2 niveles. ", 2, 0, 0)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("Flecher", 2, bc, prize,0)

    #Creación de "Los hondos"
    bc = DeathBadConsequence.new("Estos monstruos resultan bastante " + "superficiales y te aburren mortalmente. Estás muerto")
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Los Hondos ", 8, bc, prize,0)

    #Creación de "Semillas Cthulhu"
    bc = NumericBadConsequence.new("Pierdes 2 niveles y 2 tesoros ocultos. ", 2, 0, 2)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Semillas Cthulhu ", 4, bc, prize,0)


    #Creación de "Pollipolipo volante"
    bc = NumericBadConsequence.new("Da mucho asquito. Pierdes 3 niveles. ",3,0,0)
    prize = Prize.new(2,1)
    @unusedMonsters << Monster.new("Pollipólipo volante",3,bc,prize,0)


    #Creación de "YskhtihyssgGoth"
    bc = DeathBadConsequence.new("No le hace gracia que "+
            "pronuncien mal su nombre. Estas muerto. ")
    prize = Prize.new(3,1)
    @unusedMonsters << Monster.new("YskhtihyssgGoth",14,bc,prize,0)


    #Creación de "Familia feliz"
    bc = DeathBadConsequence.new("La familia te atrapa. Estás muerto.")
    prize = Prize.new(3, 1)
    @unusedMonsters << Monster.new("Familia Feliz ", 1, bc, prize,0)

    #Creación de "Roboggoth"
    t_visible = [TreasureKind::BOTHHANDS]
    t_hidden = []
    bc = SpecificBadConsequence.new("La quinta directiva" +
    " primaria te obliga a perder 2 niveles y" +
    " un tesoro 2 manos visible. ",2,t_visible,t_hidden)
    prize = Prize.new(2,1)
    @unusedMonsters << Monster.new("Roboggoth",8,bc,prize,0)

    #Creación de "El espía sordo"
    t_visible = [TreasureKind::HELMET]
    t_hidden = []
    bc = SpecificBadConsequence.new("Te asusta en la noche. Pierdes un " + "casco visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("El espía sordo ", 5, bc, prize,0)

    #Creación de "Tongue"
    bc = NumericBadConsequence.new("Menudo susto te llevas. " +
    "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0)
    prize = Prize.new(2,1)
    @unusedMonsters << Monster.new("Tongue",19,bc,prize,0)

    #Creación de "Bícefalo"
    t_visible = [TreasureKind::BOTHHANDS]
    t_hidden = []
    bc = NumericBadConsequence.new("Te faltan manos para tanta cabeza. " + "Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,10, 0)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Bicéfalo ",21,bc, prize,0)
    
    #Creación de "El mal decible impronunciable"
    bc = NumericBadConsequence.new("Pierdes una mano visible",0,1,0);
    prize = Prize.new(3,1);
    @unusedMonsters << Monster.new("El mal decible impronunciable",10,bc,prize,-2)

    #Creación de "Testigos Oculares"
    bc = NumericBadConsequence.new("Pierdes tus tesoros visibles. Jajaja.",0,10,0);
    prize = Prize.new(2,1);
    @unusedMonsters << (Monster.new("Testigos Oculares",6,bc,prize,2))

    #Creación de "El gran cthulhu"
    bc = DeathBadConsequence.new("Hoy no es tu dia de suerte. Mueres")
    prize = Prize.new(2,5);
    @unusedMonsters << Monster.new("El gran cthulhu",20,bc,prize,+4)

    #Creación de "Serpiente Politico"
    bc = NumericBadConsequence.new("Tu gobierno te recorta dos niveles",2,0,0)
    prize = Prize.new(2,1);
    @unusedMonsters << Monster.new("Serpiente Politico",8,bc,prize,-2)

    #Creación de "Felpuggoth"
    tVisible = [TreasureKind::HELMET,TreasureKind::ARMOR]
    tHidden = [TreasureKind::BOTHHANDS,TreasureKind::ONEHAND,TreasureKind::ONEHAND]
    bc = SpecificBadConsequence.new("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas",0,tVisible,tHidden);
    prize = Prize.new(1,1);
    @unusedMonsters << Monster.new("Felpuggoth",2,bc,prize,+5)

    #Creación de Shoggoth
    bc = NumericBadConsequence.new("Pierdes 2 niveles",2,0,0);
    prize = Prize.new(4,2);
    @unusedMonsters << Monster.new("Shoggoth",16,bc,prize,-4)

    #Creación de Lolitagooth
    bc = NumericBadConsequence.new("Pintalabios negro. Pierdes 2 niveles",2,0,0)
    prize = Prize.new(1,1);
    @unusedMonsters << Monster.new("Lolitagooth",2,bc,prize,+3)
    
    @unusedMonsters.shuffle!
 end
  
  def initCultistsCardDeck()
        
    @unusedCultists << Cultist.new("Sectario 1",1)
    @unusedCultists << Cultist.new("Sectario 2",2)
    @unusedCultists << Cultist.new("Sectario 3",1)
    @unusedCultists << Cultist.new("Sectario 4",2)
    @unusedCultists << Cultist.new("Sectario 5",1)
    @unusedCultists << Cultist.new("Sectario 6",1)
       
    @unusedCultist.shuffle!
  end
    
  def shuffleTreasures()
    @unusedTreasures.shuffle!
  end
  
  def shufffleMonsters()
    @unusedMonsters.shuffle!
  end
end
end
