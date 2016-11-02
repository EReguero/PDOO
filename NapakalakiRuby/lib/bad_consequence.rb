# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.


class BadConsequence
  attr_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death
  private_class_method :new
  
  def initialize(text, levels, nVisible, nHidden, death, specificVisibleTreasures, specificHiddenTreasures)
		@text = text
		@levels = levels
		@nVisibleTreasures = nVisible
		@nHiddenTreasures = nHidden
		@death = death
		@specificHiddenTreasures = specificHiddenTreasures
		@specificVisibleTreasures =  specificVisibleTreasures
	end
  def self.newLevelNumberOfTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
   new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, [] , [],false)
  end
  
  def self.newLevelSpecificTreasures (aText, someLevels,someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels,0,0,someSpecificVisibleTreasures, someSpecificHiddenTreasures,false)
  end
  
  def self.newDeath (aText)
    new(aText,0,0,0,[],[],true)
  end
  
  
  def to_s
    "Text #{@text} \n Level lost: #{@levels}, nVisibleTreasures: #{@nVisibleTreasures},
    nHiddenTreasures: #{@nHiddenTreasures}, death: #{@death}"
  end 
end
