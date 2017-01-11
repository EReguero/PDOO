#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

module NapakalakiGame
class BadConsequence
  @@MAXTREASURES = 10
 
  attr_reader :text,:levels
 
  
  def initialize (aText,someLevels)
    @text = aText
    @levels = someLevels
  end
  

  def substractVisibleTreasure(treasure)
  
  end
  
  def substractHiddenTreasure(treasure)
   
  end
  
  def adjustToFitTreasureLists(v,h);
   
  end
  
  def getLevels
     @levels
  end
  
  def isEmpty
   
  end
  def to_s
    "BadConsequence: #{@text} 
    Niveles: #{@levels}"
    
  end
end
end