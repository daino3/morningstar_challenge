load File.expand_path('../config/environment.rb', __FILE__)

c = Customer.new("A", 1, 2)
r = Register.new("normal")
s = Store.new(r)

