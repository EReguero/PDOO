# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
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
