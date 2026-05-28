# Ein ungerichteter Graph.  Durchgeführt mit einer Nachbarschaftsliste.
# Jede Kante ist zweimal geschrieben: einmal in eine Nachbarliste, und
# einmel in die anderen.
class Graph:

    # Eine Nachbarliste ist eine Liste von Liste von ganzen Zahlen.
    # Die Zahlen sind gleichzeitig die Namen und die Indexe der Knoten.
    nachbarliste = []
    
    # paare: Liste von Paaren von ganzen Zahlen
    #
    # Die Paare sind Kanten von einem Knoten bis einem anderen.
    #
    # groesse: Anzahl der Knoten
    def __init__(self, groesse, paare):
        self.groesse = groesse

        # Am Anfang hat die Graph N leere Listen.
        for i in range(groesse):
            self.nachbarliste.append([])

        # Fügen alle Kanten in der Graph ein.
        for paar in paare:
            kanteVon = paar[0]
            kanteBis = paar[1]
            
            self.nachbarliste[kanteVon].append(kanteBis)
            self.nachbarliste[kanteBis].append(kanteVon)

            
