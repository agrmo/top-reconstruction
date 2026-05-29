from random import randrange

# Das Schnellordnen. Das "Quicksort."
#
# Ordne alle Zahlen von der am geringsten bis der am größten.
# 
# liste: Liste von ganzen Zahlen
def schnellordne(liste):

    if len(liste) == 0:
        return liste
    elif len(liste) == 1:
        return liste
    elif len(liste) == 2:
        if liste[0] < liste[1]:
            return liste
        else:
            return [liste[1], liste[0]]
    else:
        # Drehpunkt: Zeichen der Liste
        drehpunkt = randrange(0, len(liste) - 1)

        # Zahl an der Stelle.
        drehpunkt_zahl = liste[drehpunkt]

        klein = []
        gross = []

        for zahl in liste:
            if (zahl < drehpunkt_zahl):
                klein.append(zahl)
            else:
                gross.append(zahl)

        klein_geordnet = schnellordne(klein)
        gross_geordnet = schnellordne(gross)

        klein_geordnet.extend(gross_geordnet)

        return klein_geordnet
        
