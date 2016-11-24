#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative "bad_consequence.rb"
require_relative "treasure.rb"
require_relative "treasure_kind.rb"

class CardDealer
  include Singleton
  
  def initialize
    @used_monsters = Array.new
    @unused_monsters = Array.new
    @used_treasures = Array.new
    @unused_treasures = Array.new
  end
  
  def next_treasure()
    
  end
  
  def next_monster()
    
  end
  
  def give_treasure_back(treasure)
    @used_treasures << treasure
  end
  
  def give_monster_back(monster)
   @used_monsters << monster
  end
  
  def init_cards()
    
  end
  
  private #Los siguientes métodos son privados
  
  def init_treasure_card_deck()
    @unused_treasures << Treasure.new("¡Sí mi amo!",4,TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Botas de investigacion",3,TreasureKind::SHOES)
    @unused_treasures << Treasure.new("Capucha de Cthulhu",3,TreasureKind::HELMET)
    @unused_treasures << Treasure.new("A prueba de babas",2,TreasureKind::ARMOR)
    @unused_treasures << Treasure.new("Botas de lluvia acida",1,TreasureKind::BOTHHANDS)
    @unused_treasures << Treasure.new("Casco minero",2,TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Ametralladora ACME",4,TreasureKind::BOTHHANDS)
    @unused_treasures << Treasure.new("Camiseta de la ETSIIT",1,TreasureKind::ARMOR)
    @unused_treasures << Treasure.new("Clavo de rail ferroviario",3,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Cuchillo de sushi arcano",2,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Fez alópodo",3,TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Hacha prehistorica",2,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("El aparato del Pr. Tesla",4,TreasureKind::ARMOR)
    @unused_treasures << Treasure.new("Gaita",4,TreasureKind::BOTHHANDS)
    @unused_treasures << Treasure.new("Insecticida",2,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Escopeta de 3 cañones",4,TreasureKind::BOTHHANDS)
    @unused_treasures << Treasure.new("Garabato místico",2,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("La rebeca metalica",2,TreasureKind::ARMOR)
    @unused_treasures << Treasure.new("Lanzallamas",4,TreasureKind::BOTHHANDS)
    @unused_treasures << Treasure.new("Necrocomicón",1,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Necronomicón",5,TreasureKind::BOTHHANDS)
    @unused_treasures << Treasure.new("Linterna a 2 manos",3,TreasureKind::BOTHHANDS)
    @unused_treasures << Treasure.new("Necrognomicón",2,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Necrotelecom",2,TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Mazo de los antiguos",3,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Necroplayboycón",3,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Porra preternatural",2,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Shogulador",1,TreasureKind::BOTHHANDS)
    @unused_treasures << Treasure.new("Varita de atizamiento",3,TreasureKind::ONEHAND)
    @unused_treasures << Treasure.new("Tentáculo de pega",2,TreasureKind::HELMET)
    @unused_treasures << Treasure.new("Zapato deja-amigos",1,TreasureKind::SHOES)
  end
  
  def init_monster_card_deck()
    #Creación de "3 Byakhees de bonanza"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = [TreasureKind::ARMOR]
    bc = BadConsequence.new_level_specific_treasures("Pierdes tu armadura visible y otra oculta ",0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unused_monsters << Monster.new("3 Byakhees de bonanza ", 8, bc,prize)

    #Creación de "Tenochtitlan"
    t_visible = [TreasureKind::HELMET]
    t_hidden = []
    bc = BadConsequence.new_level_specific_treasures("Embobados con el lindo primigenio te descartas de tu casco visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unused_monsters << Monster.new("Tenochtitlan ", 2, bc, prize)

    #Creación de "El sopor de Dunwich"
    t_visible = [TreasureKind::SHOES]
    t_hidden = []
    bc = BadConsequence.new_level_specific_treasures("El primordial bostezo contagioso. " + "Pierdes el calzado visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unused_monsters << Monster.new("El sopor de Dunwich ", 2, bc, prize)

    #Creación de "Demonios de Magaluf"
    t_visible = [TreasureKind::ONEHAND]
    t_hidden = [TreasureKind::ONEHAND]
    bc = BadConsequence.new_level_specific_treasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo." + "Descarta 1 mano visible y 1 mano oculta. ", 0, t_visible, t_hidden)
    prize = Prize.new(4, 1)
    @unused_monsters << Monster.new("Ángeles de la noche ibizenca ", 14, bc, prize)

    #Creación de  "El gorrón en el umbral"
    bc = BadConsequence.new_level_of_treasures("Pierdes todos tus tesoros visibles. ", 0,@@MAXTREASURES, 0)
    prize= Prize.new(3, 1)
    @unused_monsters << Monster.new("El gorrón en el umbral.", 13, bc, prize)

    #Creación de  "H.P. Munchcraft"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = []
    bc = BadConsequence.new_level_specific_treasures("Pierdes la armadura visible.", 0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unused_monsters << Monster.new("H.P. Munchcraft", 6, bc, prize)

    #Creación de "Necrófago"
    t_visible = [TreasureKind::ARMOR]
    t_hidden = []
    bc = BadConsequence.new_level_specific_treasures("Sientes bichos bajo la ropa. Descarta la armadura visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unused_monsters << Monster.new("Necrófago ", 13, bc, prize)

    #Creación de "El rey de rosado"
    bc = BadConsequence.new_level_of_treasures("Pierdes 5 niveles y 3 tesoros visibles. ", 5, 3, 0 )
    prize = Prize.new(3,2)
    @unused_monsters << Monster.new("El rey de rosado", 13, bc, prize)

    #Creación de "Flecher"
      bc = BadConsequence.new_level_of_treasures("Toses los pulmones y pierdes 2 niveles. ", 2, 0, 0)
    prize = Prize.new(1, 1)
    @unused_monsters << Monster.new("Flecher", 2, bc, prize)

    #Creación de "Los hondos"
    bc = BadConsequence.new_death("Estos monstruos resultan bastante " + "superficiales y te aburren mortalmente. Estás muerto")
    prize = Prize.new(2, 1)
    @unused_monsters << Monster.new("Los Hondos ", 8, bc, prize)

    #Creación de "Semillas Cthulhu"
    bc = BadConsequence.new_level_of_treasures("Pierdes 2 niveles y 2 tesoros ocultos. ", 2, 0, 2)
    prize = Prize.new(2, 1)
    @unused_monsters << Monster.new("Semillas Cthulhu ", 4, bc, prize)

    #Creación de "Dameargo"
    t_visible = [ TreasureKind::ONEHAND]
    t_hidden = []
    bc = BadConsequence.new_level_specific_treasures("Te intentas escaquear. Pierdes una mano visible. ", 0, t_visible, t_hidden)
    prize = Prize.new(2, 1)
    @unused_monsters << Monster.new("Dameargo ", 1, bc, prize)

    #Creación de "Pollipolipo volante"
    bc = BadConsequence.new_level_of_treasures("Da mucho asquito. Pierdes 3 niveles. ",3,0,0)
    prize = Prize.new(2,1)
    @unused_monsters << Monster.new("Pollipólipo volante",3,bc,prize)


    #Creación de "YskhtihyssgGoth"
    bc = BadConsequence.new_death("No le hace gracia que "+
            "pronuncien mal su nombre. Estas muerto. ")
    prize = Prize.new(3,1)
    @unused_monsters << Monster.new("YskhtihyssgGoth",14,bc,prize)


    #Creación de "Familia feliz"
    bc = BadConsequence.new_death("La familia te atrapa. Estás muerto.")
    prize = Prize.new(3, 1)
    @unused_monsters << Monster.new("Familia Feliz ", 1, bc, prize)

    #Creación de "Roboggoth"
    t_visible = [TreasureKind::BOTHHANDS]
    t_hidden = []
    bc = BadConsequence.new_level_specific_treasures("La quinta directiva" +
    " primaria te obliga a perder 2 niveles y" +
    " un tesoro 2 manos visible. ",2,t_visible,t_hidden)
    prize = Prize.new(2,1)
    @unused_monsters << Monster.new("Roboggoth",8,bc,prize)

    #Creación de "El espía sordo"
    t_visible = [TreasureKind::HELMET]
    t_hidden = []
    bc = BadConsequence.new_level_specific_treasures("Te asusta en la noche. Pierdes un " + "casco visible ", 0, t_visible, t_hidden)
    prize = Prize.new(1, 1)
    @unused_monsters << Monster.new("El espía sordo ", 5, bc, prize)

    #Creación de "Tongue"
    bc = BadConsequence.new_level_of_treasures("Menudo susto te llevas. " +
    "Pierdes 2 niveles y 5 tesoros visibles.",2,5,0)
    prize = Prize.new(2,1)
    @unused_monsters << Monster.new("Tongue",19,bc,prize)

    #Creación de "Bícefalo"
    t_visible = [TreasureKind::BOTHHANDS]
    t_hidden = []
    bc = BadConsequence.new_level_of_treasures("Te faltan manos para tanta cabeza. " + "Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,@@MAXTREASURES, 0)
    prize = Prize.new(2, 1)
    @unused_monsters << Monster.new("Bicéfalo ",21,bc, prize)
 end
  
  def shuffle_treasures()
    @unsued_treasures.shuffle!
  end
  
  def shufffle_monsters()
    @unused_monsters.shuffle!
  end
end
