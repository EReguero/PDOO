# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
  att_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death
  
  @text
  @levels
  @nVisibleTreasures
  @nHiddenTreasures
  @death
  
  
  def to_s
    "Text #{@text} \n Level lost: #{@levels}, nVisibleTreasures: #{@nVisibleTreasures},
    nHiddenTreasures: #{@nHiddenTreasures}, death: #{@death}"
  end 
end
