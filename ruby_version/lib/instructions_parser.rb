class InstructionsParser

  def initialize(file)
    @file = file
    @data = parse
    @num_regs = @data.shift[0].to_i
  end

  def create_store
    Store.new(create_registers, create_customers)
  end

  def parse
    separator  = " "
    file_data  = []
    CSV.foreach(@file, col_sep: separator) do |row|
      file_data << row
    end
    file_data
  end

  def create_registers
    @num_regs.times.map do |number|
      number + 1 == @num_regs ? Register.new(TRAINING) : Register.new(NORMAL) #last register is training reg
    end
  end

  def create_customers
    @data.map do |data|
      hash = {}
      hash[:type]  = data[0]
      hash[:arrival_time] = data[1].to_i
      hash[:items] = data[2].to_i
      Customer.new(hash)
    end 
  end
end
