from graph.graph import Graph
from druck.graph.graph import drucke_graph

# python -m graph.main

def main():
    g = Graph(4, [[1,2],[0,1]])
    drucke_graph(g)

if __name__ == "__main__":
    main()
