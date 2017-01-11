#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative "treasure_kind.rb"

module NapakalakiGame
class Treasure
  attr_reader :name, :bonus, :type
  
  def initialize(name, bonus, type)
    @name = name
    @bonus = bonus
    @type = type
  end
  
  def getType
   @type
  end 
  
  def to_s
    "Nombre: #{@name}, Bonus: #{@bonus}, Tipo: #{type.to_s}"
  end
end
end
