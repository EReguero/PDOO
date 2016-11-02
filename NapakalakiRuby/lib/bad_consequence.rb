# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
encoding: utf-8

class BadConsequence
  att_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death
  
  def initialize(text, levels, nVisible, nHidden, death, specificVisibleTreasures, specificHiddenTreasures)
		@text = text
		@levels = levels
		@nVisibleTreasures = nVisible
		@nHiddenTreasures = nHidden
		@death = death
		@specificHiddenTreasures = specificHiddenTreasures.clone
		@specificVisibleTreasures =  specificVisibleTreasures.clone
	end
  
  def to_s
    "Text #{@text} \n Level lost: #{@levels}, nVisibleTreasures: #{@nVisibleTreasures},
    nHiddenTreasures: #{@nHiddenTreasures}, death: #{@death}"
  end 
end
