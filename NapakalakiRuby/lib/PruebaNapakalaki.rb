# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor
#!/bin/env ruby
# encoding: utf-8

require_relative"prize.rb"
require_relative"monster.rb"
require_relative"bad_consequence.rb"
require_relative"treasure_kind.rb"

class PruebaNapakalaki

  @@monsters = Array.new
  
  
   def self.display_monsters(monsters, msg)
            puts "\n*** #{msg} ***\n"
            puts monsters
   end
  
  def self.nivelSuperiora10(monsters)
      monsters.select { |m| m.level > 10}
    
  end
  
  def self.solo_niveles(monsters)
      monsters.select { |m| 
          m.badConsequence.levels > 0 and m.badConsequence.nVisibleTreasures == 0 and m.badConsequence.nVisibleTreasures == 0
      }
  end

  def self.ganarmasde1(monsters)
      monsters.select { |m| m.prize.levels >= 1}
  end

  def self.tesoro_especifico(kind, monsters)
      monsters.select { |m|
          m.badConsequence.specific_visible_treasures.member?(kind) or
          m.badConsequence.specific_hidden_treasures.member?(kind)
      }
  end
def self.main() 

  #Monstruo El rey de rosa
  price = Prize.new(4,2) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles',5 , 3, 0)
  @@monsters << Monster.new('El rey de rosa',13,price,badConsequence)

  #Angeles de la noche ibicenca
  prize = Prize.new(4,1) 
  badConsequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta',0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
  @@monsters<< Monster.new('Angeles de la noche ibicenca', 14, prize, badConsequence) 

  #Monstruo 3 Byakhees de bonanza
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes tu armadura visible y otra oculta ',0 , [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  @@monsters << Monster.new('3 Byakhees de bonanza',8,prize,badConsequence)

  #Monstruo Tenochtitlan
  price = Prize.new(1,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Embobados con el lindo primigenio te descartas de tu casco visible ',0 , [TreasureKind::HELMET], [])
  @@monsters << Monster.new('Tenochtitlan',2,prize,badConsequence)

  #Monstruo El sopor de Dunwich
  price = Prize.new(1,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('El primordial bostezo contagioso. ',0 , [TreasureKind::SHOES], [])
  @@monsters << Monster.new('El sopor de Dunwich',2,prize,badConsequence)

  #Monstruo El gorrón en el umbral
  price = Prize.new(3,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos tus tesoros visibles.  ',0 , 10, 0)

  #Monstruo H.P. Munchcraft
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes la armadura visible ',0 , [TreasureKind::ARMOR],0)
  @@monsters << Monster.new('H.P. Munchcraft',6,prize,badConsequence)

  #Monstruo Necrófago
  price = Prize.new(1,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Sientes bichos bajo la ropa. Descarta la armadura visible ',0 , [TreasureKind::ARMOR], [])
  @@monsters << Monster.new('Necrofago',13,prize,badConsequence)

  #Monstruo El rey de rosado
  price = Prize.new(3,2) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles', 5, 3, 0)
  @@monsters << Monster.new('El rey de rosado',11,prize,badConsequence)

  #Monstruo Flecher
  price = Prize.new(1,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones y pierdes 2 niveles. ', 2, 0, 0)
  @@monsters << Monster.new('Flecher',2,prize,badConsequence)

  #Monstruo Los hondos
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newDeath('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto ')
  @@monsters << Monster.new('Los hondos',8,prize,badConsequence)

  #Monstruo Semillas Cthulhu
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ocultos.  ', 2, 0, 2)
  @@monsters << Monster.new('Semillas Cthulhu',4,prize,badConsequence)

  #Monstruo Dameargo
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Te intentas escaquear. Pierdes una mano visible. ',0 , [TreasureKind::ONEHAND],0)
  @@monsters << Monster.new('Dameargo',1,prize,badConsequence)

  #Pollipólipo volante
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes 3 niveles.', 3, 0,0)
  @@monsters << Monster.new('Pollipolipo volante',3,prize,badConsequence)

  #Monstruo YskhtihyssgGoth
  price = Prize.new(3,1) 
  badConsequence = BadConsequence.newDeath('No le hace gracia que pronuncien mal su nombre. Estas muerto. ')
  @@monsters << Monster.new('YskhtihyssgGoth',14,prize,badConsequence)

  #Monstruo Familia Feliz
  price = Prize.new(3,1) 
  badConsequence = BadConsequence.newDeath('La familia te atrapa. Estas muerto.')
  @@monsters << Monster.new('Familia Feliz',1,prize,badConsequence)

  #Monstruo Roboggoth
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible. ', 2, 2,0)
  @@monsters << Monster.new('Roboggoth',8,prize,badConsequence)

  #Monstruo El espía sordo
  price = Prize.new(1,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Te asusta en la noche. Pierdes un casco visible ',0 , [TreasureKind::HELMET],0)
  @@monsters << Monster.new('El espia sordo',5,prize,badConsequence)

  #Monstruo Tongue
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles. ', 2, 5,0)
  @@monsters << Monster.new('Tongue',19,prize,badConsequence)

  #Monstruo Bicéfalo
  price = Prize.new(2,1) 
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos. ', 3, 10,0)
  @@monsters << Monster.new('Bicefalo',21,prize,badConsequence)

   
end
 
end
  PruebaNapakalaki.main