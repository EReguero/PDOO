#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative 'treasure.rb'
require_relative 'card_dealer.rb'
require_relative 'dice.rb'
require_relative 'bad_consequence.rb'
require_relative 'monster.rb'
require_relative'treasure_kind.rb'
require_relative 'combat_result.rb'

module NapakalakiGame
class Player
  @@MAX_LEVEL = 10
  attr_reader :name, :hiddenTreasures, :visibleTreasures, :level, :dead, :MAX_LEVEL
  attr_accessor :enemy, :pendingBadConsequence
  def initialize (name)
    @name = name
    @level = 1
    @dead = true
    @canISteal = true
    @hiddenTreasures = Array.new
    @visibleTreasures = Array.new
    @enemy = nil
    @pendingBadConsequence = nil
  end
  
    def new_player(player)
    @name = player.name           
    @level = player.level
    @dead = player.dead    
    @canISteal = player.canISteal
    @enemy = player.enemy                       
    @visibleTreasures = player.visible_treasures
    @hiddenTreasures = player.hidden_treasures     
    @pendingBadConsequence = player.pending_bad_consequence 
  end
  
  def canISteal
    @canISteal
  end
  
  def self.getMaxLevel
    max = @@MAX_LEVEL
  end
  
  def to_s
    "#{@name}, Nivel: #{@level}"
  end
  
  def combat(monster)
    my_level = getCombatLevel
    monster_level = monster.getCombatLevel
    
    if(!@canISteal)
      dice = Dice.instance
      number = dice.next_number
      if(number < 3)
        enemy_level = enemy.getCombatLevel
        monster_level = monster_level + enemy_level
      end
    end
      
    if(my_level > monster_level)
      applyPrize(monster)
      if(@level >= @@MAX_LEVEL)
         combat_result = CombatResult::WINGAME
      else
         combat_result = CombatResult::WIN
      end
    else
      applyBadConsequence(monster);
      combat_result = CombatResult::LOSE
      if(shouldConvert)
        combat_result = CombatResult::LOSEANDCONVERT
      end
    end
    
    combat_result
  end
  
  def makeTreasureVisible(treasure)
    can_i = canMakeTreasureVisible(treasure)
    
    if(can_i)
      @visibleTreasures << treasure
      @hiddenTreasures.delete(treasure)
    end
  end
  
  def discardVisibleTreasure(treasure)
    @visibleTreasures.delete(treasure)
    if(@pendingBadConsequence != nil)
      @pendingBadConsequence.substractVisibleTreasure(treasure)
    end
    
    dieIfNoTreasures
  end
  
  def discardHiddenTreasure(treasure)
    @hiddenTreasures.delete(treasure)
    if(@pendingBadConsequence != nil)
      @pendingBadConsequence.substractHiddenTreasure(treasure)
    end
    
    dieIfNoTreasures
  end
  
  def validState()
    valid = false
    if((@hiddenTreasures.size < 4) && @pendingBadConsequence == nil)
      valid = true
    end
    
    valid
  end
  
  def initTreasures()
    dealer = CardDealer.instance
    dice = Dice.instance
    bringToLife
    treasure = dealer.nextTreasure
    @hiddenTreasures << treasure
    
    number = dice.next_number
    
    if(number > 1)
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
      if(number == 6)
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end
    end
  end
  
  def stealTreasure()
    if(@canISteal)
      can_you = canYouGiveMeATreasure
      if(can_you)
        t = giveMeATreasure
        @hiddenTreasures << t
        haveStolen
      end
    end
  end
  
  def setEnemy(enemy)
    @enemy = enemy
  end
  
  def discardAllTreasures()
   
    
    for t in @visibleTreasures
      discardVisibleTreasure(t)
    end
    
    for t in @hiddenTreasures
      discardHiddenTreasure(t)
    end
  end
  
  def getHiddenTreasures()
    @hiddenTreasures
  end
  
  def getVisibleTreasures()
    @visibleTreasures
  end
  
  def shouldConvert 
    dice = Dice.instance
    n = dice.next_number
    convert = false
    
    if(n == 1)
      convert = true
    end
    convert
  end
  
  private  #Los siguientes metodos son privados
  
  def bringToLife
    @dead = false
  end
  
  def incrementLevels(i)
    @level = @level + i
  end
  
  def decrementLevels(i)
    @level = @level - i
  end
  
  def applyPrize(m)
    n_levels = m.getLevelsGained
    incrementLevels(n_levels)
    
    n_treasures = m.getTreasuresGained
    if(n_treasures > 0)
      dealer = CardDealer.instance
      for i in 1..n_treasures
       t = dealer.nextTreasure()
      @hiddenTreasures << t
      end     
    end
  end
  
  def applyBadConsequence(m)
    bad_consequence = m.getBadConsequence()
    n_levels = bad_consequence.getLevels
    decrementLevels(n_levels)
    pending_bad = bad_consequence.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures)
    @pendingBadConsequence = pending_bad;
  end
  
 
  
  def canMakeTreasureVisible(treasure)
    type = treasure.type
    can_make_visible = true
        
      case type 
        when (TreasureKind::ONEHAND)
              if(howManyVisibleTreasures(TreasureKind::BOTHHANDS)>0 || 
                    howManyVisibleTreasures(TreasureKind::ONEHAND) >1)
                   can_make_visible= false
              end
        when TreasureKind::BOTHHANDS
              if(howManyVisibleTreasures(TreasureKind::BOTHHANDS)>0 ||
                     howManyVisibleTreasures(TreasureKind::ONEHAND) > 0)
                  can_make_visible = false
              end
        else
              if(howManyVisibleTreasures(type)>0)
                   can_make_visible = false
              end
      end   
    
    can_make_visible
  end
  
  def howManyVisibleTreasures(t_kind)
    n = 0;
    for treasure in @visibleTreasures
      if(treasure.type == t_kind)
        n = n +1
      end
    end   
    n
  end
  
  def dieIfNoTreasures
    if(@visibleTreasures.empty? && @hiddenTreasures.empty?)
      @dead = true
    end
  end
  
  def giveMeATreasure()
    n = rand(@visibleTreasures.length)
    treasure = @visibleTreasures.at(n)
    @visibleTreasures.delete_at(n)
    
    treasure
  end
  
  def canYouGiveMeATreasure()
    can_steal = true
    if(@hiddenTreasures.empty?)
      can_steal = false
    end
    
    can_steal
  end
  
  def haveStolen
    @canISteal = false
  end
  
 
  def getCombatLevel
    combat_level = @level
    
    for a_treasure in @visibleTreasures
      combat_level = combat_level + a_treasure.bonus
    end
    
    combat_level
  end
  
  def getOpponentLevel(m)
    level = m.combatLevel
    levl
  end
  #Protected
  protected
  def get_enemy
    return @enemy
  end
  
end
end
