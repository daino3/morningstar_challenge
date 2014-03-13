load File.expand_path('../config/environment.rb', __FILE__)

store1 = Store.new(File.open(EXAMPLE_1))
store2 = Store.new(File.open(EXAMPLE_2))
store3 = Store.new(File.open(EXAMPLE_3))
store4 = Store.new(File.open(EXAMPLE_4))
store5 = Store.new(File.open(EXAMPLE_5))

def run_app(num, store)
  puts "#{num}) Finished at #{store.run!} minutes!"
end

run_app(1, store1)
run_app(2, store2)
run_app(3, store3)
run_app(4, store4)
run_app(5, store5)
