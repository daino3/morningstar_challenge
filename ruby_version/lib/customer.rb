class Customer
  def initialize(type, time, items)
    @type  = type
    @time  = time
    @items = items
  end

  def check_lines(grocery_store)
    grocery_store.registers.each do |register|
      register.number_of_customers
    end
  end

  def ring_item
    @items -= 1
  end
end
