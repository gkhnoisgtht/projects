def mod3(x):
	return ((x % 3) == 0)

def mod5(x):
	return ((x % 5) == 0)

for i in range(1, 100):
	if mod3(i) and mod5(i):
		print "FizzBuzz"
	elif mod3(i):
		print "Fizz"
	elif mod5(i):
		print "Buzz"
	else:
		print i


