#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero


class Dice
  include Singleton
  
  def next_number()
    n = rand(5)+1
  end
  
end
