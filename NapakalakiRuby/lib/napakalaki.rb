#encoding: utf-8
#Autor: Dunia Rodríguez y Emilio Reguero
require_relative 'player'
require_relative 'card_dealer'
require_relative 'monster'

class Napakalaki
  
  include Singleton 
  
  attr_reader :currentPlayer, :currentMonster, :dealer, :players
  
  def initialize
    @players = Array.new
    @currentMonster = nil
    @currentPlayer = nil
    @dealer = CardDealer.instance
  end
  
  def getCurrentPlayer
    @currentPlayer
  end
  
  def getCurrentMonster
    @currentMonster
  end
 
  def developCombat()
    combat_result = @currentPlayer.combat(@currentMonster)
    @dealer.giveMonsterBack(@currentMonster)
    
    combat_result
  end
  
  def discardVisibleTreasures(treasures)
    treasures.each do treasure
      @currentPlayer.discardVisibleTreasure(treasure)
      @dealer.giveTreasureBackack(treasure)
    end
  end
  
  def discardHiddenTreasures(treasures)
     treasures.each do treasure
      @currentPlayer.discardHiddenTreasure(treasure)
      @dealer.giveTreasureBackack(treasure)
    end
  end
  
  def makeTreasuresVisible(treasures)
    i = 0
    while(i < treasures.size)
      t = treasures[i]
      @currentPlayer.makeTreasure_Visible(t)
      i = i +1  
    end
  end
  
  def initGame(players)
   initPlayers(players)
   setEnemies
   dealer.initCards
   nextTurn
  end
  
  def nextTurn()
    state_ok = nextTurnIsAllowed
    
    if state_ok 
      @currentMonster = dealer.nextMonster
      @currentPlayer = nextPlayer
      dead = currentPlayer.dead
      if dead
        @currentPlayer.initTreasures
      end
    end
    
    state_ok
  end
  
  def endOfGame(result)
    win_game = false
    if(result == CombatResult::WINGAME)
      win_game = true
    end
    
    win_game
  end
  
  
  private #A partir de aqui todos los metodos privados
  
  def initPlayers(names)
    names.each do |name|
      @players << Player.new(name)
    end
  end
  
  def nextPlayer()
    total_players = @players.length
    
    if(@currentPlayer == nil) then
      n = rand(total_players)
    else
      n = (@players.index(@currentPlayer))+1
      n = n % total_players;
    end
    
    next_player = @players.at(n)
    @currentPlayer = next_player
    
    @currentPlayer
  end
  
  def nextTurnIsAllowed()
    allowed = false
    if(@currentPlayer == nil || @currentPlayer.validState())
      allowed = true
    end
    
    allowed
  end
  
  def setEnemies()
    pos = 0
    @players.each do |player|
     
      n = rand(@players.length)
      while n == pos
         n = rand(@players.length)
      end
      
      player.setEnemy(@players[n])
    end
  end
  
   
  
end
