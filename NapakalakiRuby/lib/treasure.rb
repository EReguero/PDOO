#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative "treasure_kind.rb"
class Treasure
  attr_reader :name, :bonus, :type
  
  def initialize(name, bonus, type)
    @name = name
    @bonus = bonus
    @type = type
  end
end
