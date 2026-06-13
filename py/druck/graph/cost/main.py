from graph.cost.costgraph import Costgraph
from druck.graph.cost.costgraph import drucke_costgraph

# python -m druck.graph.cost.main

def main():
    g = Costgraph(4, [[1,2],[0,1]], [5,6,7,8])
    drucke_costgraph(g)

if __name__ == "__main__":
    main()
