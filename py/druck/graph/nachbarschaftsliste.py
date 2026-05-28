
def drucke_nachbarschaftsliste(graph):
    for i, liste in enumerate(graph.nachbarschaftsliste):
        print(str(i) + ': ' + str(liste))
