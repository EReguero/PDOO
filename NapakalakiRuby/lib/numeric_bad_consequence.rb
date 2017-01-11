# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
class NumericBadConsequence < BadConsequence
  
  attr_reader :nVisibleTreasures        # Number of visible treasures to lose
  attr_reader :nHiddenTreasures         # Number of hidden treasures t
  
  def initialize(aText, someLevels,someVisibleTreasures, someHiddenTreasures)
    super(aText, someLevels)

    @nVisibleTreasures = someVisibleTreasures
    if(someVisibleTreasures > @@MAXTREASURES)
      @nVisibleTreasures = @@MAXTREASURES
    end
      
    @nHiddenTreasures = someHiddenTreasures
    if(someHiddenTreasures > @@MAXTREASURES)
      @nHiddenTreasures = @@MAXTREASURES
    end     
  end
  
  def substractVisibleTreasure (t)
    if (@nVisibleTreasures > 0 )
        @nVisibleTreasures -= 1
    end
  end
    
  def substractHiddenTreasure (t)
    if (@nHiddenTreasures > 0 )
       @nHiddenTreasures -= 1
    end
  end
  
  def adjustToFitTreasureLists(v, h)
    
      nVisibleT= @nVisibleTreasures
      nHiddenT = @nHiddenTreasures
      
      if(v.size < @nVisibleTreasures)
        nVisibleT = v.size
      end
      if(h.size < @nHiddenTreasures)
        nHiddenT = h.size
      end
      
      adjustBC = NumericBadConsequence.new(@text, @levels, nVisibleT, nHiddenT)
      return adjustBC
  end
  
  def is_empty ()
    result = false
    if ((@nVisibleTreasures == 0) && (@nHiddenTreasures == 0))
      result = true
    end   
    result
  end
  
  def to_s
    
    respuesta = super.to_s
    respuesta += " \nnVisibleTreasures: #{@n_visible_treasures}\nnHiddenTresures: #{@n_hidden_treasures} "
 
  end
  
    
  end
end

