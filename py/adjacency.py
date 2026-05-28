def abstractAdjLtoMatrix(graph, initialVal, matrixIn, matrixV):
    meMatrix = [[initialVal for i in range(len(graph))] for i in range(len(graph))]

    for n in range(len(graph)):
        for newNode in graph[n]:
            meMatrix[n][matrixIn(newNode)] = matrixV(newNode)

    return meMatrix

def adjLtoMatrix(graph):
    matrixIn = lambda newNode: newNode
    matrixV = lambda newNode: True
    return abstractAdjLtoMatrix(graph, False, matrixIn, matrixV)

def weightedAdjLtoMatrix(graph):
    matrixIn = lambda newNode: newNode[0]
    matrixV = lambda newNode: newNode[1]
    return abstractAdjLtoMatrix(graph, 0, matrixIn, matrixV)
