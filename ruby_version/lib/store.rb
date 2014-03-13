class Store
  attr_reader :registers, :customers, :time

  def initialize(registers, customers)
    @registers = registers
    @customers = customers
    @time  = 0
  end

  def run!
    until all_customers_served?
      place_customers_in_line
      service_customers
      @time += 1
    end
    @time
  end

  def all_customers_served?
    @customers.all?(&:served)
  end

  def place_customers_in_line
    arrivals = find_line_arrivals
    sorted   = sort_arrivals(arrivals)
    sorted.each do |customer|
      customer.get_in_line(self)
    end
  end

  def find_line_arrivals
    @customers.find_all { |customer| @time == customer.arrival_time }
  end

  def sort_arrivals(arrivals)
    arrivals.sort { |a, b| [a.type, a.items] <=> [b.type, b.items] }
  end

  def service_customers
    return if @registers.all?(&:empty?)
    @registers.each do |register|
      register.serve_current_customer
    end
  end

  def shortest_line
    @registers.min_by(&:line_length)
  end

  def last_customer_with_least_items
    @registers.min_by(&:last_customer_items) 
  end

end
