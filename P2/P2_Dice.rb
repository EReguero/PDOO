# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
include Singleton
class Dice
  include Singleton
  def initialize
    #codigo aleatorio
    rand(5)+1
  end
end
