#!/usr/bin/env ruby

class Token
	def initialize(type, value)
		@type=type
		@value=value
	end

	def to_string()
		puts "TOKEN(#{@type},#{@value})"
	end

end

class Interpreter
	def initialize(text)
		@pos = 0
		@current_token = nil
		@text = text
		@current_char = @text[0]
	end

	def is_whitespace(char)
		return char == " "
	end

	def numeric?(lookAhead)
  		lookAhead =~ /[0-9]/
	end

	def advance()
		 
	end

	def skip_whitespace()
		while @current_char not nil and not is_whitespace(@current_char)
			@pos += 1
			@current_char = @text[@pos]
		end
	end

	def get_next_token()
		if is_whitespace(@current_char)
			skip_whitespace()
		end

		if numeric?(@current_char)
		end

		
	end

	def expr()
	
	end


end
