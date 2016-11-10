# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Player
  @@MAXLEVEL = 10
  def initialize(nombre, nivel, enemigo, pBC, muerte = true, can_i_s=true)
    @name = nombre
    @level = nivel
    @dead = muerte
    @canISteal = can_i_s
    @enemy = enemigo
    @pendingBadConsequence = pBC
    @visibleTreasures = Array.new
    @hiddenTreasures = Array.new
  end
  
  def player(name)
    
    
  end
  
  def get_name
    
  end
  
  private
  def bring_to_life
    
  end
  
  private
  def getCombatLevel
   # each contador con if
  end
  
  private
  def incrementLevels(l)
    
  end
  
  private
  def decrementLevels(l)
    #que no se pasa de un si se pasa pues se pone a uno.
  end
  
  private 
  def setPendingBadConsequence(b)
    
  end
  
  private
  def applyPrize(m)
    
  end
  
  private
  def applyBadConsequence(m)
    
  end
  
  private 
  def canMakeTreasureVisible(t)
    
  end
  
  private 
  def howManyVisibleTreasures(tKind)
    #ech contando cuntos hay de un determinado tipo
  end
  
  private
  def dieIfNoTreasures
    #=true
  end
  
  def isDead
    @dead
  end
  
  def getHiddenTreasures
    
  end
  
  def getVisibleTreasures
    
  end
  
  def combat(m)
    
  end
  
  def makeTreasureVisible(t)
    
  end
  
  def discardVisibleTreasure(t)
    
  end
  
  def discardHiddenTreasure(t)
    
  end
  
  def validState
    
  end
  
  def initTreasures
    
  end
  
  def getLevels
    
  end
  
  def stealTreasure
    
  end
  
  def stealTreasure
    
  end
  
  def setEnemy(enemy)
    
  end
  
  def giveMeATreasure
    
  end
  
  def canISteal
    
  end
  
  private
  def canYouGiveMeATreasure
    #ver si array de tesoros si te puedo dar tesros si no está vacio
  end
  
  private
  def  haveStolen
    
  end
  
 def  discardAllTreasures
   
 end
  
end
