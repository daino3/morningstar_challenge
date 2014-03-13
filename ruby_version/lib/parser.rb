module Parser

  def self.parse(file)
    separator  = " "
    file_data  = []
    CSV.foreach(file, col_sep: separator) do |row|
      file_data << row
    end
    file_data
  end

end
