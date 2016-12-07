#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative 'bad_consequence.rb'
require_relative 'treasure.rb'
require_relative 'treasure_kind.rb'
require 'singleton'

class CardDealer
  include Singleton
  
  def initialize
    @usedMonsters = Array.new
    @unusedMonsters = Array.new
    @usedTreasures = Array.new
    @unusedTreasures = Array.new
  end
  
  def next_treasure()
    if @unusedTreasures.empty?
      @unusedTreasures = @usedTreasures;
      usedTreasures = Array.new
      shuffleTreasures
    end
    sig = @unusedTreasures
    @unusedTreasures.delete(0);
    @usedTreasures << sig
    
    sig
  end
  
  def nextMonster()
     if @unusedMonsters.empty?
      @unusedMonsters = @usedMonsters;
      @usedMonsters = Array.new
      shuffleMonsters
    end
    sig = @unusedMonsters
    @unusedMonsters.delete(0);
    @usedMonsters << sig
    
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
  end
  
  def initMonsterCardDeck()
    #Creación de "3 Byakhees de bonanza"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = [TreasureKind::ARMOR]
    bc = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta ",0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("3 Byakhees de bonanza ", 8, bc,prize)

    #Creación de "Tenochtitlan"
    t_visible = [TreasureKind::HELMET]
    t_hidden = []
    bc = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("Tenochtitlan ", 2, bc, prize)

    #Creación de "El sopor de Dunwich"
    t_visible = [TreasureKind::SHOES]
    t_hidden = []
    bc = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. " + "Pierdes el calzado visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("El sopor de Dunwich ", 2, bc, prize)

    #Creación de "Demonios de Magaluf"
    t_visible = [TreasureKind::ONEHAND]
    t_hidden = [TreasureKind::ONEHAND]
    bc = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo." + "Descarta 1 mano visible y 1 mano oculta. ", 0, t_visible, t_hidden)
    prize = Prize.new(4, 1)
    @unusedMonsters << Monster.new("Ángeles de la noche ibizenca ", 14, bc, prize)

    #Creación de  "El gorrón en el umbral"
    bc = BadConsequence.newLevelOfTreasures("Pierdes todos tus tesoros visibles. ", 0,10, 0)
    prize= Prize.new(3, 1)
    @unusedMonsters << Monster.new("El gorrón en el umbral.", 13, bc, prize)

    #Creación de  "H.P. Munchcraft"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = []
    bc = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible.", 0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("H.P. Munchcraft", 6, bc, prize)

    #Creación de "Necrófago"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = []
    bc = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("Necrófago ", 13, bc, prize)

    #Creación de "El rey de rosado"
    bc = BadConsequence.newLevelOfTreasures("Pierdes 5 niveles y 3 tesoros visibles. ", 5, 3, 0 )
    prize = Prize.new(3,2)
    @unusedMonsters << Monster.new("El rey de rosado", 13, bc, prize)

    #Creación de "Flecher"
      bc = BadConsequence.newLevelOfTreasures("Toses los pulmones y pierdes 2 niveles. ", 2, 0, 0)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("Flecher", 2, bc, prize)

    #Creación de "Los hondos"
    bc = BadConsequence.new_death("Estos monstruos resultan bastante " + "superficiales y te aburren mortalmente. Estás muerto")
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Los Hondos ", 8, bc, prize)

    #Creación de "Semillas Cthulhu"
    bc = BadConsequence.newLevelOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos. ", 2, 0, 2)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Semillas Cthulhu ", 4, bc, prize)

    #Creación de "Dameargo"
    t_visible = [ TreasureKind::ONEHAND]
    t_hidden = []
    bc = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible. ", 0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Dameargo ", 1, bc, prize)

    #Creación de "Pollipolipo volante"
    bc = BadConsequence.newLevelOfTreasures("Da mucho asquito. Pierdes 3 niveles. ",3,0,0)
    prize = Prize.new(2,1)
    @unusedMonsters << Monster.new("Pollipólipo volante",3,bc,prize)


    #Creación de "YskhtihyssgGoth"
    bc = BadConsequence.new_death("No le hace gracia que "+
            "pronuncien mal su nombre. Estas muerto. ")
    prize = Prize.new(3,1)
    @unusedMonsters << Monster.new("YskhtihyssgGoth",14,bc,prize)


    #Creación de "Familia feliz"
    bc = BadConsequence.new_death("La familia te atrapa. Estás muerto.")
    prize = Prize.new(3, 1)
    @unusedMonsters << Monster.new("Familia Feliz ", 1, bc, prize)

    #Creación de "Roboggoth"
    t_visible = [TreasureKind::BOTHHANDS]
    t_hidden = []
    bc = BadConsequence.newLevelSpecificTreasures("La quinta directiva" +
    " primaria te obliga a perder 2 niveles y" +
    " un tesoro 2 manos visible. ",2,t_visible,t_hidden)
    prize = Prize.new(2,1)
    @unusedMonsters << Monster.new("Roboggoth",8,bc,prize)

    #Creación de "El espía sordo"
    t_visible = [TreasureKind::HELMET]
    t_hidden = []
    bc = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un " + "casco visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unusedMonsters << Monster.new("El espía sordo ", 5, bc, prize)

    #Creación de "Tongue"
    bc = BadConsequence.newLevelOfTreasures("Menudo susto te llevas. " +
    "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0)
    prize = Prize.new(2,1)
    @unusedMonsters << Monster.new("Tongue",19,bc,prize)

    #Creación de "Bícefalo"
    t_visible = [TreasureKind::BOTHHANDS]
    t_hidden = []
    bc = BadConsequence.newLevelOfTreasures("Te faltan manos para tanta cabeza. " + "Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,10, 0)
    prize = Prize.new(2, 1)
    @unusedMonsters << Monster.new("Bicéfalo ",21,bc, prize)
 end
  
  def shuffleTreasures()
    @unsuedTreasures.shuffle!
  end
  
  def shufffleMonsters()
    @unusedMonsters.shuffle!
  end
end
