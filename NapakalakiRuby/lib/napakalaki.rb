#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero
require_relative "player.rb"

class Napakalaki
  
  include Singleton 
  
  attr_reader :current_player, :current_monster, :dealer, :players
  
  def initialize
    @players = Array.new
    @current_monster = nil
    @current_player = nil
    @dealer = CardDealer.instance
  end
  
 
  def develop_combat()
    
  end
  
  def discard_visible_treasures()
    
  end
  
  def discard_hidden_treasures()
    
  end
  
  def make_treasures_visible()
    
  end
  
  def init_game()
    
  end
  
  def next_turn()
    
  end
  
  def end_of_game(result)
    win_game = false
    if(result == CombatResult::WINGAME)
      win_game = true
    end
    
    win_game
  end
  
  
  private #A partir de aqui todos los metodos privados
  
  def init_players(names)
    names.each do |name|
      @players << Player.new(name)
    end
  end
  
  def next_player()
    total_players = @players.length
    
    if(@current_player == nil) then
      n = rand(total_players)
    else
      n = (@players.index(@current_player))+1
      n = n % total_players;
    end
    
    next_player = @players.at(n)
    @current_player = next_player
    
    @current_player
  end
  
  def next_turn_is_allowed()
    allowed = false
    if(@current_player == nil || @current_player.valid_state())
      allowed = true
    end
    
    allowed
  end
  
  def set_enemies()
    pos = 0
    @players.each do |player|
     
      n = rand(@players.length)
      while n == pos
         n = rand(@players.length)
      end
      
      player.set_enemy(@players[n])
    end
  end
  
end
