#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero

require_relative "treasure.rb"

class Player
  @@MAX_LEVEL = 10
  attr_reader :name, :hidden_treasures, :visible_treasures, :level, :dead
  attr_accesor :enemy, :pending_bad_consequence
  def initialize (name)
    @name = name
    @level = 1
    @dead = true
    @can_i_steal = true
    @hidden_treasures = Array.new
    @visible_treasures = Array.new
    @enemy = nil
    @pending_bad_consequence = nil
  end
  
  def combat(monster)
    
  end
  
  def make_treasure_visible (treasure)
    
  end
  
  def discard_visible_treasure(treasure)
    
  end
  
  def discard_hidden_treasure(treasure)
    
  end
  
  def valid_state()
    valid = true
    if((@hidden_treasures.size < 4) && @pending_bad_consequence == nil || @pending_bad_consequence.empty? )
      valid = false
    end
    
    valid
  end
  
  def init_treasures()
    
  end
  
  def steal_treasure()
  
  end
  
  def set_enemy(enemy)
    @enemy = enemy
  end
  
  def discard_all_treasures()
    
  end
  
  
  private  #Los siguientes metodos son privados
  
  def bring_to_life
    @dead = false
  end
  
  def increment_levels(i)
    @level = @level + i
  end
  
  def decrement_levels(i)
    @level = @level - i
  end
  
  def apply_prize
    
  end
  
  def apply_bad_consequence
    
  end
  
  def can_make_treasure_visible(t)
    
  end
  
  def how_many_visible_treasures(t_kind)
    n = 0;
    for treasure in @visible_treasures
      if(treasure.type == t_kind)
        n = n +1
      end
    end   
    n
  end
  
  def die_if_no_treasures
    if(@visible_treasures.empty? && @hidden_treasures.empty?)
      @dead = true
    end
  end
  
  def give_me_a_treasure()
    
  end
  
  def can_you_give_me_a_treasure()
    can_steal = true
    if(@hidden_treasures.empty?)
      can_steal = false
    end
    
    can_steal
  end
  
  def have_stolen()
    @can_i_steal = false
  end
  
  def get_combat_level()
    combat_level = 0
    
    for a_treasure in @visible_treasures
      combat_level = combat_level + a_treasure.bonus
    end
    
    combat_level
  end
  
end
