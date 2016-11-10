# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Treasure
  def initialize(unname, unbonus, untype)
    @name = unname
    @bonus = unbonus
    @type = untype
  end
  
  def getName
    @name    
  end
  
  def getBonus
    @bonus
  end
  
  def getType
    @type
  end
  
end
