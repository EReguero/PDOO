#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative "prize.rb"
require_relative "bad_consequence.rb"

class Monster
  attr_reader :name, :combatLevel, :prize, :bc, :MAXTREASURES
  
  @@MAXTREASURES = 10 
  def initialize(name, level, prize, bc)
    @name = name
    @combatLevel = level
    @prize = prize
    @bc = bc
  end
  
  def getLevelsGained
    @prize.level
  end
  
  def getTreasuresGained
    @prize.treasures
  end
  
  def to_s
    "Monster: #{@name}, combatLevel: #{@combatLevel} \n #{@bc} \n #{@prize}"
  end
  
end
