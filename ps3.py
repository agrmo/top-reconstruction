def generate_configuration_model():
    import networkx
    from networkx.utils import powerlaw_sequence
    import math
    
    pl_seq = networkx.utils.random_sequence.powerlaw_sequence(15625, 2.5)
    pl_seq_int = [math.floor(degree) for degree in pl_seq]

    # networkx.random_powerlaw_tree_sequence is too expensive.
    # So we'll need to use powerlaw_sequence I suppose.
    # "Invalid degree sequence: sum of degrees must be even, not odd"
    # I suppose I need to hack around this error.
    
    if (sum(pl_seq_int) % 2 != 0):
        pl_seq_int[0] += 1

    multig = networkx.configuration_model(pl_seq_int)    
    rebelgraph = networkx.Graph(multig)
    
    return rebelgraph

def get_list_of_rebels_by_local_clustering(rebelgraph):
    # Input: Graph
    # Output: List of (int, double)
    #
    # Pretend we're big brother, and we are given a graph of all the
    # rebels a rebel network. We want to remove rebels from the graph
    # in some order. The metric we'll choose for this function is to
    # remove rebels by order of largest clustering coefficient. Return
    # a list of rebels, where the first rebel has the highest
    # clustering coefficient.
    
    import networkx
    
    clustering = networkx.clustering(rebelgraph)
    list_of_rebels = list()
    
    for node, localclustering in clustering.items():
        list_of_rebels.append((node, localclustering))
        
    list_of_rebels.sort(key=lambda rebel: rebel[1], reverse=True)

    return list_of_rebels


def get_list_of_rebels_by_degree(rebelgraph):
    # Input: Graph
    # Output: List of (int, double)
    #
    # Dual function as big_brother_hitlist_local_clustering. But the
    # metric is degree.
    
    import networkx

    list_of_rebels = rebelgraph.degree()
    list_of_rebels_sorted = sorted(list_of_rebels, key=lambda rebel: rebel[1], reverse=True)

    return list_of_rebels_sorted

def remove_nodes_and_plot(rebelgraph, list_of_rebels, howremove):
    # This algorithm doesn't know what the graph is, how it was
    # generated, how how the rebels were selected to be removed. What
    # it does know is to remove the first rebel in the list
    # successively, and to plot the size of the largest component.

    import networkx
    import matplotlib.pyplot

    num_rebels_removed = 0

    x_axis = list()
    y_axis = list()

    for rebel in list_of_rebels[:1000]:
        rebelgraph.remove_node(rebel[0])

        num_rebels_removed += 1
        x_axis.append(num_rebels_removed)

        connectedcomponents = networkx.connected_components(rebelgraph)
        connectedcomponents_sorted = sorted(connectedcomponents, key=len, reverse=True)
        y_axis.append(len(connectedcomponents_sorted[0]))
    
    axis = matplotlib.pyplot.gca()
    axis.set_title('Configuration Model.')
    axis.set_xlabel('Number of rebels removed')
    axis.set_ylabel('Size of largest component')
    matplotlib.pyplot.scatter(x_axis, y_axis, label=howremove)
    axis.legend()

def q1():
    rebelgraph = generate_configuration_model()
    list_of_rebels = get_list_of_rebels_by_local_clustering(rebelgraph)
    remove_nodes_and_plot(rebelgraph, list_of_rebels, 'Local clustering removal')

    rebelgraph = generate_configuration_model()
    list_of_rebels = get_list_of_rebels_by_degree(rebelgraph)
    remove_nodes_and_plot(rebelgraph, list_of_rebels, 'Degree removal')

    import matplotlib.pyplot
    matplotlib.pyplot.show()
    
    print('Exiting')

def main():
    q1()
    
if __name__ == '__main__':
    main()
