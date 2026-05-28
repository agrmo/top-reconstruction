from graph.nachbarschaftsliste import Nachbarschaftsliste
from druck.graph.nachbarschaftsliste import drucke_nachbarschaftsliste

# python -m graph.main

def main():
    n = Nachbarschaftsliste(4, [[1,2],[0,1]])
    drucke_nachbarschaftsliste(n)

if __name__ == "__main__":
    main()
