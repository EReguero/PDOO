#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative "prize.rb"
require_relative "bad_consequence.rb"
module NapakalakiGame
class Monster
  attr_reader :name, :combatLevel, :prize, :bc, :MAXTREASURES
  
  @@MAXTREASURES = 10 
  def initialize(name, level, bc, prize,lc)
    @name = name
    @combatLevel = level
    @priz = prize
    @bc = bc
    @lc = 0
  end
  
  
  def getLevelsGained
    @priz.level
  end
  
  def getTreasuresGained
    @priz.treasures
  end
  
  def getCombatLevel
    @combatLevel
  end
  
  def getCombatLevelAgainstCultistPlayer
    @combatLevel + @levelChangeAgainstCultistPlayer
  end
  
  def getBadConsequence
    @bc
  end
  

  def to_s
    "Monster: #{@name}, combatLevel: #{@combatLevel} \n #{@bc} \n #{@prize}"
  end
  
end
end
