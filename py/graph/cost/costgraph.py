# An undirected graph, where each node has a cost to be moved to.
class Costgraph:

    # Eine Nachbarliste ist eine Liste von Liste von ganzen Zahlen.
    # Die Zahlen sind gleichzeitig die Namen und die Indexe der Knoten.
    nachbarliste = []

    # Costs: List of integer.
    #
    # Cost of moving to each node at index i.
    costs = []
    
    # paare: Liste von Paaren von ganzen Zahlen
    #
    # Die Paare sind Kanten von einem Knoten bis einem anderen.
    #
    # groesse: Anzahl der Knoten
    def __init__(self, groesse, paare, costs):
        self.groesse = groesse
        self.costs = costs

        # Am Anfang hat die Graph N leere Listen.
        for i in range(groesse):
            self.nachbarliste.append([])

        # Fügen alle Kanten in der Graph ein.
        for paar in paare:
            kanteVon = paar[0]
            kanteBis = paar[1]
            
            self.nachbarliste[kanteVon].append(kanteBis)
            self.nachbarliste[kanteBis].append(kanteVon)

