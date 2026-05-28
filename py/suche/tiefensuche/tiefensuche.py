# Tiefensuche
#
# graph: graph.graph.Graph
# Eine Nachbarschaftsliste. Der ungerichtete Graph muss keinen Zyklus haben.
#
# anfangknoten: int
# Name des Knoten
def tiefensuche(graph, anfangknoten):

    # Fangen wir mit dem Anfangknoten an.
    zusehen = [anfangknoten]
    gesehen = []

    # Während es Knoten zu sehen gibt.
    while len(zusehen) > 0:

        # Der näechste Knoten.
        naechste = zusehen.pop(0)

        # Der näechste Knoten ist gesehen.
        gesehen.append(naechste)
        
        for nachbar in graph.nachbarliste[naechste]:

            # n.b. mit einer Liste ist "n not in gesehen" O(n). Wir
            # können eine Menge gleichzeitig bauen, sodaß wir "n not
            # in gesehenMenge" stattdessen berechnen, was O(1) ist,
            # aber es ist mir jetzt egal.
            if nachbar not in gesehen:
                zusehen.insert(0, nachbar)

    return gesehen
