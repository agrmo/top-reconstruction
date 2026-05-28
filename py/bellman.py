import sys

def bellman(g):
	d = [sys.maxsize] * len(g)
	d[0] = 0
	
	for _ in range(len(g) - 2):
		diff = False
		for n in range(len(g)):
			for e in g[n]:
				if d[n] + e[1] < d[e[0]]:
					d[e[0]] = d[n] + e[1]
					diff = True
		if not diff:
			return d

	return d

