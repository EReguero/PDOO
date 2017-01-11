#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero
module NapakalakiGame
class DeathBadConsequence < NumericBadConsequence
 
  attr_reader :death  
  
  def initialize(text)
    @death = true
    super(text, Player.getMaxLevel, @@MAXTREASURES, @@MAXTREASURES)
  end
  
  def is_empty
    result = false
  end
  
  def to_s
    respuesta = super.to_s + "\n Has muerto"
  end
  end
end

