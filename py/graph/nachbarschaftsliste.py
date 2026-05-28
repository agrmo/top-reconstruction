class Nachbarschaftsliste:
    nachbarschaftsliste = []
    
    # paare: Liste von Paaren von ganzen Zahlen
    # groesse: Anzahl der Knoten
    def __init__(self, groesse, paare):
        self.groesse = groesse

        # Am Anfang hat die Nachbarschaftsliste N leere Listen.
        for i in range(groesse):
            self.nachbarschaftsliste.append([])

        # Fügen alle Kanten in der Nachbarschaftsliste ein.
        for paar in paare:
            kanteVon = paar[0]
            kanteBis = paar[1]
            
            self.nachbarschaftsliste[kanteVon].append(kanteBis)

            
