import networkx
import matplotlib.pyplot

def largest_component():
    g = networkx.readwrite.gml.read_gml('./netscience.gml')

    list_of_node_degree = list()

    for node in list(g.nodes):
        list_of_node_degree.append((node, g.degree(node)))

    list_of_node_degree_sorted = sorted(list_of_node_degree, key=lambda node: node[1])

    for x in list_of_node_degree_sorted[-10:]:
        print(x[0], x[1])
        
    # edges = g.edges(index)
    # largest_component = g.edge_subgraph(edges)
    # networkx.draw(largest_component, with_labels=True)
    # matplotlib.pyplot.show()

def main():
    largest_component()

if __name__ == '__main__':
    main()
