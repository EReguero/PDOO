#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative 'treasure'
require_relative 'card_dealer'
require_relative 'dice'
require_relative 'bad_consequence'
require_relative 'monster'

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
  
 
  
  def combat(monster)
    my_level = get_combat_level
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
            apply_prize(m)
            if(this.level >= MAXLEVEL)
               combat_result = CombatResult::WINGAME;
            else
               combat_result = CombatResult::WIN;
            end
        else
            apply_bad_consequence(m);
            combat_result = CombatResult::LOSE;
      end
    combat_result
  end
  
  def makeTreasureVisible (treasure)
    can_i = canMakeTreasureVisible(treasure)
    
    if(can_i)
      @visibleTreasures << treasure
      @hiddenTreasures.delete(treasure)
    end
  end
  
  def discardVisibleTreasure(treasure)
    @visibleTreasures.delete(treasure)
    if(@pendingBadConsequence != nil || !@pendingBadConsequence.is_empty)
      @pendingBadConsequence.substract_visible_treasure(treasure)
    end
  end
  
  def discardHiddenTreasure(treasure)
    @hiddenTreasures.delete(treasure)
    if(@pendingBadConsequence != nil || !@pendingBadConsequence.is_empty)
      @pendingBadConsequence.substract_hidden_treasure(treasure)
    end
  end
  
  def valid_state()
    valid = true
    if((@hiddenTreasures.size < 4) && @pendingBadConsequence == nil || @pendingBadConsequence.empty? )
      valid = false
    end
    
    valid
  end
  
  def initTreasures()
    dealer = CardDealer.instance
    dice = Dice.instance
    bringToLife
    treasure = dealer.next_treasure
    @hiddenTreasures << treasure
    
    number = dice.next_number
    
    if(number > 1)
      treasure = dealer.next_treasure
      @hiddenTreasures << treasure
      if(number == 6)
        treasure = dealer.next_treasure
        @hiddenTreasures << treasure
      end
    end
  end
  
  def stealTreasure()
    if(@canISteal)
      can_you = canYouGiveMeATreasure
      if(can_you)
        t = give_me_a_treasure
        @hiddenTreasures << t
        have_stolen
      end
    end
  end
  
  def setEnemy(enemy)
    @enemy = enemy
  end
  
  def discard_all_treasures()
    copy_visibleTreasures = @visibleT_teasures
    copy_hiddenTreasures = @hiddenTreasures
    
    copy_visibleTreasures.each do t
      discardVisibleTreasure(t)
    end
    
    copy_hiddenTreasures.each do t
      discardHiddenTreasure(t)
    end
  end
  
  def getHiddenTreasures
    @hiddenTreasures
  end
  
  def getVisibleTreasures
    @visibleTreasures
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
      dealer = CardDealer.instance;
      for i in 1..n_treasures
       t = dealer.nextTreasure();
       hiddenTreasures.add(t);
      end     
    end
  end
  
  def applyBadConsequence(m)
    bad_consequence = m.get_bad_consequence();
    n_levels = bad_consequence.get_levels();
    decrementLevels(n_levels);
    pending_bad = badConsequence.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures);
    @pendingBadConsequence = pending_bad;
  end
  
 
  
  def canMakeTreasureVisible(t)
    type = t.get_type
    can_make_visible = true
        
      case type 
        when TreasureKind::ONEHAND
              if(howManyVisibleTreasures(TreasureKind::BOTHHANDS)>0 || 
                    howManyVisibleTreasures(TreasureKind::ONEHAND) >1)
                   can_make_visible= false
              end
        when TreasureKind::BOTHHANDS
              if(howManyVisibleTreasures(TreasureKind.BOTHHANDS)>0 ||
                     howManyVisibleTreasures(TreasureKind.ONEHAND) > 0)
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
   @visibleTreasures.each do treasure
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
  
  def haveStolen()
    @canISteal = false
  end
  
  def getCombatLevel()
    combat_level = 0
    
    for a_treasure in @visibleTreasures
      combat_level = combat_level + a_treasure.bonus
    end
    
    combat_level
  end
  
end
