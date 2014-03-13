class Store
  attr_reader :registers, :customers, :time

  def initialize(file)
    @file  = file
    @time  = 0
    parse_instructions
  end

  def parse_instructions
    instructions  = Parser.parse(@file)
    num_registers = instructions.shift[0].to_i
    @registers  ||= create_registers(num_registers)
    @customers  ||= create_customers(instructions)
  end

  def run!
    until all_customers_served?
      place_customers_in_line
      service_customers
      @time += 1
    end
    @time
  end

  def create_registers(num)
    num.times.map do |number|
      number + 1 == num ? Register.new(TRAINING) : Register.new(NORMAL) #last register is training reg
    end
  end

  def create_customers(instructions)
   instructions.map do |data|
     hash = {}
     hash[:type]  = data[0]
     hash[:arrival_time] = data[1].to_i
     hash[:items] = data[2].to_i
     Customer.new(hash)
   end 
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
