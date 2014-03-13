class Register
  attr_reader :speed, :line

  def initialize(speed)
    @speed = speed
    @line  = []
    @wait  = 0
  end

 def serve_customer(customer)
   customer.ring_item
   customer.time += 1
 end

end
