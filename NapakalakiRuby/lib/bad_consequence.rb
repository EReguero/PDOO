#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

class BadConsequence
  @@MAXTREASURES = 10
  attr_reader :text,:levels,:nVisibleTreasures,:nHiddenTreasures,:death, :MAXTREASURES
  private_class_method :new
  
  def initialize (aText,someLevels,nVisible,nHidden,death,tVisible,tHidden)
    @text = aText
    @levels = someLevels
    @n_visible_treasures = nVisible
    @n_hidden_treasures = nHidden
    @specific_visible_treasures = tVisible
    @specific_hidden_treasures = tHidden
    @death = death
  end
  
  def self.new_level_of_treasures (aText,someLevels,nHidden,nVisible)
    new(aText,someLevels,n_visible,nHidden,[],[],false)
  end
  
  def self.new_level_specific_treasures (aText,someLevels,tVisible,tHidden)
    new(aText,someLevels,0,0,tVisible,tHidden,false)
  end
  
  def self.new_death (aText)
    new(aText,0,0,0,[],[],true)
  end
  
  def substract_visible_treasure(treasure)
    
  end
  
  def substract_hidden_treasure(treasure)
    
  end
  
  def adjust_to_fit_treasure_list(v,h)
    
  end
  
  def is_empty
    empty = false;
    if((@n_visible_treasures == 0) && (@n_hidden_treasures == 0) && 
          (@specific_visible_treasures.empty?) && (@specific_hidden_treasures.empty?))
        empty = true
    end
    
    empty
  end
  def to_s
    "BadConsequence: #{@text} \n Niveles: #{@levels}, nVisibleTerasures: 
      #{@n_visible_treasures}, nHiddenTreasures: #{@n_hidden_treasures}\n
      SpecificVisibleTreasures: #{@specific_visible_treasures}, 
      SpecificHiddenTreasures: #{@specific_hidden_treasures}"
  end
end
