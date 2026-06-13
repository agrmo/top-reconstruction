import sys

def dijk(graph, src):
	dist = [sys.maxsize] * len(graph)
	seen = [False] * len(graph)
	dist[src] = 0
	for _ in range(len(seen)):
		u = getIndex(seen, dist)
		seen[u] = True
		for v in range(len(graph)):
			if seen[v] == False and graph[u][v] > 0 and dist[u] + graph[u][v] < dist[v]:
				dist[v] = dist[u] + graph[u][v]
	return dist

def getIndex(seen, dist):
	min = sys.maxsize
	minIndex = 0
	for v in range(len(seen)):
		if seen[v] == False and dist[v] < min:
			min = dist[v]
			minIndex = v
	return minIndex

