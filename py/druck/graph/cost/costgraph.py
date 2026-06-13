
# Drucke jeden Knoten mit seiner Preis.
#
def drucke_costgraph(costgraph):
    for i, nachbarn in enumerate(costgraph.nachbarliste):
        print(str(i) + ': Cost ' + str(costgraph.costs[i]) + ': ' + str(nachbarn))
