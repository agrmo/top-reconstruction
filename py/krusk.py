def findMinCycle(graph):
	edge = kruskal(graph)
	return edge

def kruskal(graph):
	seenNodes = set()
	
	for e in graph:
		if e[0] in seenNodes and e[1] in seenNodes:
			return e
		seenNodes.add(e[0])
		seenNodes.add(e[1])

	return (0,0,0)
