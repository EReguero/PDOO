#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero
module NapakalakiGame
class Cultist

     attr_reader :name, :gainedLevels
  
  def initialize(nam, gainedlevels)
    @name = nam
    @gainedLevels = gainedlevels
  end
  
  def getGainedLevels
    @gainedLevels
  end
end
end
