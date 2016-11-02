# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
<<<<<<< HEAD
require_relative "prize.rb"
require_relative "bad_consequence.rb"
=======
encoding: utf-8
>>>>>>> origin/master

class Monster
  attr_reader :name, :level, :bd, :prize
  
  def initialize (name, level, bc, prize)
    @name=name
    @level=level
    @badConsequence = bc
    @prize = prize
  end
  
end
