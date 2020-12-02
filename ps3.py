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

def generate_hierarchical_model():
    import networkx
    import math

    def get_base_module():
        # Make a fully connected graph of five nodes. We definitely
        # need their names to be unique, so generate that now.
        
        complete_graph = networkx.generators.classic.complete_graph(5)

        import random
        import string

        def get_random_name(old_name):
            return ''.join(random.choice(string.ascii_uppercase + string.digits) for _ in range(10))        
        
        complete_graph = networkx.relabel_nodes(complete_graph, get_random_name)
        nodes = list(complete_graph.nodes)

        return complete_graph, nodes[0], nodes[1:]

    def connect_modules(graph, center_node, list_of_peripheral_nodes):
        for node in list_of_peripheral_nodes:
            graph.add_edge(node, center_node)

        return graph

    def get_five_modules(depth):
        # Make a graph from five modules, one being the center module,
        # and the other four being the peripheral modules. Connect all
        # nodes of the peripheral modules to the center node of the
        # center module.
        
        if depth == 0:
            return get_base_module()
        
        modules = [get_five_modules(depth - 1) for _ in range(5)]
        periphs = list()
        center_module, center_node, periphs_of_center = modules[0]
        from networkx.algorithms.operators import union

        for (module, modcenter, modperiphs) in modules[1:]:
            periphs.extend(modperiphs)
            center_module = union(center_module, module)
        
        final_graph = connect_modules(center_module, center_node, periphs)

        return final_graph, center_node, periphs

    # Depth of 5 has 15625 nodes. 6, 78125. 7, 390625.
    # Great. That math checks out.
    
    (a,_,_) = get_five_modules(7)

    return a

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
    # rebelgraph = generate_configuration_model()
    # list_of_rebels = get_list_of_rebels_by_local_clustering(rebelgraph)
    # remove_nodes_and_plot(rebelgraph, list_of_rebels, 'Local clustering removal')

    # rebelgraph = generate_configuration_model()
    # list_of_rebels = get_list_of_rebels_by_degree(rebelgraph)
    # remove_nodes_and_plot(rebelgraph, list_of_rebels, 'Degree removal')

    rebelgraph = generate_hierarchical_model()
    list_of_rebels = get_list_of_rebels_by_degree(rebelgraph)
    remove_nodes_and_plot(rebelgraph, list_of_rebels, 'Degree removal')

    # rebelgraph = generate_hierarchical_model()
    # list_of_rebels = get_list_of_rebels_by_degree(rebelgraph)
    # remove_nodes_and_plot(rebelgraph, list_of_rebels, 'Degree removal')

    import matplotlib.pyplot
    matplotlib.pyplot.show()
    
    print('Exiting')

def main():
    q1()
    
if __name__ == '__main__':
    main()
