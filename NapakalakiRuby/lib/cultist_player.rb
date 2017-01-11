# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
class CultistPlayer < Player
  @@totalCultistPlayers
  
  def initialize(p,c)
    @myCultistCard = c
    super(p.name)
    new_player(p)
    @@totalCultistPlayers += 1
  end
  
  def getCombatLevel
    level = super
    level *= 1.
    level += @myCultistCard.gainedLevels
    level *= @@totalCultistPlayers
    level.floor
  end
  
  def getOponentLevel(m)
    m.getCombatLevelAgainstCultistPlayer;
  end
  
  
  def shouldConvert 
    convert = false
  end
  private
  def giveMeATreasure
    n = rand(@visibleTreasures.size())
    t = @visibleTreasures[n]
    @visibleTreasures.delete(t)
    return t
  end
  
  def canYouGiveMeATreasure
    result = !(@visibleTreasures.empty?)
    result
  end
end
end
