from suche.breitensuche.breitensuche import breitensuche
from graph.graph import Graph

# python -m suche.breitensuche.main

def main():

    #                1 
    #              /
    # 0 ---- 5 - 2 - 4 - 11
    #         \
    #          3
    #           \
    #            6
    #      7
    #      |
    #      8 - 9 - 10
    #
    g = Graph(12,[[0,5],[5,2],[5,3],[3,6],[2,4],[2,1],[7,8],[8,9],[10,9],[11,4]])
    gesehen = breitensuche(g, 0)
    print(gesehen)

    gesehen = breitensuche(g, 8)
    print(gesehen)

if __name__ == "__main__":
    main()
