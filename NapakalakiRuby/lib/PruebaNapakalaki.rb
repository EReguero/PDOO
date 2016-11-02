# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
encoding: utf-8
require_relative "prize.rb"
require_relative "bad_consequence"

class PruebaNapakalaki
 
  @@misMonster = Array.new
  @MAX_VALUE = 10
 
#Monstruo El rey de rosa
price = Prize.new(4,2) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles',5 , 3, 0)
@@monsters << Monster.new('El rey de rosa',13,prize,badConsequence)
 
#Angeles de la noche ibicenca
prize = Prize.new(4,1) 
badConsequence = BadConsequence.newLevelSpecificTreasures ('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta', 0,[TrearureKind::ONEHAND], [TrearureKind::ONEHAND])
@@monsters<< Monster.new('Ángeles de la noche ibicenca', 14, prize, badConsequence) 

#Monstruo 3 Byakhees de bonanza
price = Prize.new(2,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes tu armadura visible y otra oculta ',0 , [TrearureKind::ARMOR], [TrearureKind::ARMOR])
@@monsters << Monster.new('3 Byakhees de bonanza',8,prize,badConsequence)

#Monstruo Tenochtitlan
price = Prize.new(1,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Embobados con el lindo primigenio te descartas de tu casco visible ',0 , [TrearureKind::HELMET], [])
@@monsters << Monster.new('Tenochtitlan',2,prize,badConsequence)

#Monstruo El sopor de Dunwich
price = Prize.new(1,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('El primordial bostezo contagioso. ',0 , [TrearureKind::SHOES], [])
@@monsters << Monster.new('El sopor de Dunwich',2,prize,badConsequence)

#Monstruo Demonios de Magaluf
price = Prize.new(4,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visile y 1 mano oculta',0 , [TrearureKind::ONEHAND], [TrearureKind::ONEHAND])
@@monsters << Monster.new('Demonios de Magaluf',2,prize,badConsequence)

#Monstruo El gorrón en el umbral
price = Prize.new(3,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos tus tesoros visibles.  ',0 , MAX_VALUE, 0)

#Monstruo H.P. Munchcraft
price = Prize.new(2,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes la armadura visible ',0 , [TrearureKind::ARMOR],0)
@@monsters << Monster.new('H.P. Munchcraft',6,prize,badConsequence)

#Monstruo Necrófago
price = Prize.new(1,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Sientes bichos bajo la ropa. Descarta la armadura visible ',0 , [TrearureKind::ARMOR], [])
@@monsters << Monster.new('Necrófago',13,prize,badConsequence)

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
badConsequence = BadConsequence.newLevelNumberOfTreasures('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto ', true)
@@monsters << Monster.new('Los hondos',8,prize,badConsequence)

#Monstruo Semillas Cthulhu
price = Prize.new(2,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ocultos.  ', 2, 0, 2)
@@monsters << Monster.new('Semillas Cthulhu',4,prize,badConsequence)
  
#Monstruo Dameargo
price = Prize.new(2,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Te intentas escaquear. Pierdes una mano visible. ',0 , [TrearureKind::ONEHAND],0)
@@monsters << Monster.new('Dameargo',1,prize,badConsequence)

#Pollipólipo volante
price = Prize.new(2,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes 3 niveles.', 3, 0,0)
@@monsters << Monster.new('Pollipólipo volante',3,prize,badConsequence)
 
#Monstruo YskhtihyssgGoth
price = Prize.new(3,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('No le hace gracia que pronuncien mal su nombre. Estas muerto. ', true)
@@monsters << Monster.new('YskhtihyssgGoth',14,prize,badConsequence)
  
#Monstruo Familia Feliz
price = Prize.new(3,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('"La familia te atrapa. Estás muerto. ', true)
@@monsters << Monster.new('Familia Feliz',1,prize,badConsequence)
  
#Monstruo Roboggoth
price = Prize.new(2,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible. ', 2, 2,0)
@@monsters << Monster.new('Roboggoth',8,prize,badConsequence)
  
#Monstruo El espía sordo
price = Prize.new(1,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Te asusta en la noche. Pierdes un casco visible ',0 , [TrearureKind::HELMET],0)
@@monsters << Monster.new('El espía sordo',5,prize,badConsequence)
 
#Monstruo Tongue
price = Prize.new(2,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles. ', 2, 5,0)
@@monsters << Monster.new('Tongue',19,prize,badConsequence)

#Monstruo Bicéfalo
price = Prize.new(2,1) 
badConsequence = BadConsequence.newLevelNumberOfTreasures('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos. ', 3, MAX_VALUE,0)
@@monsters << Monster.new('Bicéfalo',21,prize,badConsequence)
 
    


end
