Dir['lib/*.rb'].each {|file| load file }
load 'config/files.rb'
load 'config/constants.rb'
require 'pry'
require 'csv'
