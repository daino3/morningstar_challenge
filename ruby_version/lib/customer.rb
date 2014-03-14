class Customer
  attr_reader :type, :arrival_time, :items, :served

  def initialize(hash)
    @type   = hash[:type]
    @items  = hash[:items]
    @arrival_time = hash[:arrival_time]
    @served = false
  end

  def get_in_line(store)
    case @type
    when TYPE_A
      register = store.shortest_line
    when TYPE_B
      register = store.last_customer_with_least_items
    end
    register.line << self
  end

  def ring_item(speed)
    @items -= speed
    @served = true if @items <= 0
  end

end
