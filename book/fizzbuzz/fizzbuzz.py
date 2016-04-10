def mod3(x):
	return ((x % 3) == 0)

def mod5(x):
	return ((x % 5) == 0)

def mod15(x):
	return mod3(x) and mod5(x)

for i in range(1, 100):
	if mod15(i):
		print "FizzBuzz"
	elif mod3(i):
		print "Fizz"
	elif mod5(i):
		print "Buzz"
	else:
		print i