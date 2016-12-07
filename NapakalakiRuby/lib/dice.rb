#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero


class Dice
  include Singleton
  
  def next_number()
    n = 1 + rand(6)
    n
  end
  
end
