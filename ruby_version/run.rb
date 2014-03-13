load File.expand_path('../config/environment.rb', __FILE__)

store1 = InstructionsParser.new(File.open(EXAMPLE_1)).create_store
store2 = InstructionsParser.new(File.open(EXAMPLE_2)).create_store
store3 = InstructionsParser.new(File.open(EXAMPLE_3)).create_store
store4 = InstructionsParser.new(File.open(EXAMPLE_4)).create_store
store5 = InstructionsParser.new(File.open(EXAMPLE_5)).create_store

def run_app(num, store)
  puts "#{num}) Finished at #{store.run!} minutes!"
end

run_app(1, store1)
run_app(2, store2)
run_app(3, store3)
run_app(4, store4)
run_app(5, store5)
