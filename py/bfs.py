from collections import deque

# bfs(adjacency list)
def bfs(graph):
	nextNodes = deque([0])
	discovered = set()
	while len(nextNodes) > 0:
		nextNode = nextNodes.popleft()
		discovered.add(nextNode)
		for n in graph(nextNode):
			if n not in discovered:
				nextNodes.appendleft(n)

	return discovered

