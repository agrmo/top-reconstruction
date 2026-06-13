from graph.cost.costgraph import Costgraph
from druck.graph.costgraph import drucke_costgraph

# python -m graph.cost.costgraph

def main():
    g = Costgraph(4, [[1,2],[0,1]], [5,5,5,5])
    drucke_costgraph(g)

if __name__ == "__main__":
    main()
