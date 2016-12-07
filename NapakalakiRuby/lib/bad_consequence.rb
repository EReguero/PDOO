#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

class BadConsequence
  @@MAXTREASURES = 10
 
  attr_reader :text,:levels,:nVisibleTreasures,:nHiddenTreasures,:death
  private_class_method :new
  
  def initialize (aText,someLevels,nVisible,nHidden,death,tVisible,tHidden)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = nVisible
    @nHiddenTreasures = nHidden
    @specificVisibleTreasures = tVisible
    @specificHiddenTreasures = tHidden
    @death = death
  end
  
  def self.newLevelOfTreasures (aText,someLevels,nHidden,nVisible)
    new(aText,someLevels,nVisible,nHidden,[],[],false)
  end
  
  def self.newLevelSpecificTreasures (aText,someLevels,tVisible,tHidden)
    new(aText,someLevels,0,0,tVisible,tHidden,false)
  end
  
  def self.new_death (aText)
    new(aText,0,0,0,[],[],true)
  end
  
  def substractVisibleTreasure(treasure)
    @specificVisibleTreasures.delete(treasure.type)
  end
  
  def substractHiddenTreasure(treasure)
    @specificHiddenTreasures.delete(treasure.type)
  end
  
  def adjust_to_fit_treasure_list(v,h)
    
  end
  
  def is_empty
    empty = false;
    if((@nVisibleTreasures == 0) && (@nHiddenTreasures == 0) && 
          (@specificVisibleTreasures.empty?) && (@specificHiddenTreasures.empty?))
        empty = true
    end
    
    empty
  end
  def to_s
    "BadConsequence: #{@text} \n Niveles: #{@levels}, nVisibleTerasures: 
      #{@nVisibleTreasures}, nHiddenTreasures: #{@nHiddenTreasures}\n
      SpecificVisibleTreasures: #{@specificVisibleTreasures}, 
      SpecificHiddenTreasures: #{@specificHiddenTreasures}"
  end
end
