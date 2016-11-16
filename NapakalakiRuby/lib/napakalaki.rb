#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero
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
  
  def end_of_game()
    
  end
  
  
  private #A partir de aqui todos los metodos privados
  
  def init_players(names)
    
  end
  
  def next_player()
    
  end
  
  def next_turn_allowed()
    
  end
  
  def set_enemies()
    
  end
end
