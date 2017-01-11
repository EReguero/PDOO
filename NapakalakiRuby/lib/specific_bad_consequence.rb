# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
class SpecificBadConsequence < BadConsequence
  
  attr_reader :specificVisiblTtreasures # Array of visible treasures
  attr_reader :specificHiddenTreasures  # Array of hidden treasures
  
  def initialize(text, someLevels,
      someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    super(text, someLevels)
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
  end
  
  def substract_visible_treasure (t)
    if (!@specificVisibleTreasures.empty?)
      @specificVisibleTreasures.delete(t.type)
    end

  end
  
   def substract_hidden_treasure (t)
    if(!@specificHiddenTreasures.empty?)
            @specificHiddenTreasures.delete(t.type)
    end
    
  end
  
   def is_empty ()
    result = false
    if ((@specificVisibleTreasures.empty?) && (@specificHiddenTreasures.empty?))
      result = true
    end   
    result
  end
  
  def adjust_to_fit_treasure_lists(v, h)
  
      # CASE 2:
      copiaV = Array.new(v)
      vTreasures = Array.new()
      
      for t in @specificVisibleTreasures
        i = 0;
        found = false;
        while (i < copiaV.size) && !(found)
          if (copiaV[i].type == t)
             found = true
             vTreasures << t
       
             #copia_v.delete_at(copia_v.index(i) || copia_v.length)
             copiaV.delete(v[i])
          end     
          i = i+1
        end
      end
                  
      copiaH = Array.new(h)
      hTreasures = Array.new()

      for t in @specificHiddenTreasures
         i = 0
         found = false
         while (i < copiaH.size) && !(found)
            
             if (copiaH[i].type == t)
                 found = true;
                 hTreasures << t
                #copia_h.delete_at(copia_h.index(i) || copia_h.length)
                copiaH.delete(h[i])
             end   
             i = i+1
         end
      end
      adjustBC = SpecificBadConsequence.new(@text,@levels,vTreasures,hTreasures)
      return adjustBC
  end
  
   def to_s
    
    respuesta = super.to_s
    respuesta += " \nvTreasures: #{@specificVisibleTreasures}\n+ hTreasures #{@specificHiddenTreasures} "
 
  end
  
  
end
end