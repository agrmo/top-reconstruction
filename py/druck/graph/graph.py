
def drucke_graph(graph):
    for i, nachbarn in enumerate(graph.nachbarliste):
        print(str(i) + ': ' + str(nachbarn))
