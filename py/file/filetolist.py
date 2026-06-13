
def filetolist(filename):
	f = open(filename)
	
	lines = f.read().splitlines()

	f.close()

	return lines
