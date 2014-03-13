class Register
  attr_reader :speed, :line

  def initialize(speed)
    @speed = 1.0/speed
    @line  = []
  end

  def serve_current_customer
    return if empty?
    customer = @line.first
    customer.ring_item(@speed)
    @line.shift if customer.served
  end

  def total_wait
    @line.map(&:items).inject(:+) # in minutes
  end

  def last_customer_items
    !empty? ? @line.last.items : 0
  end

  def line_length
    @line.length
  end

  def empty?
    @line.empty?
  end

end
