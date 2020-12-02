import networkx
import matplotlib.pyplot
import math
import numpy
import random
import powerlaw
from scipy.optimize import curve_fit
from itertools import tee

def get_graph_at_next_time_step(graph, degree_list, index_of_new_node):
    indexes_of_nodes_to_connect_to = list()

    for x in range(1,5):
        index_of_node = random.choices(list(graph.nodes), weights=degree_list)
        indexes_of_nodes_to_connect_to.append(index_of_node[0])

    # Important choice here is to not change the graph when sampling
    # for the four edges to add to the new node. Only now will we add
    # the new node to the graph and connect its edges. Also, we're
    # going to store a list of degrees for easy reference.

    graph.add_node(index_of_new_node)
    degree_list.append(len(indexes_of_nodes_to_connect_to))
    
    for index in indexes_of_nodes_to_connect_to:
        graph.add_edge(index_of_new_node, index)
        degree_list[index] += 1
        
    return graph, degree_list


def get_initial_graph():
    g = networkx.Graph()

    # Add nodes.
    
    for index_of_initial_node in range(4):
        g.add_node(index_of_initial_node)

    # Connect them.
        
    for index_of_from in range(4):
        for index_of_to in range(index_of_from, 4):

            # Dont add self loops.
            
            if index_of_from != index_of_to:
                g.add_edge(index_of_from, index_of_to)

    return g, [3, 3, 3, 3]

def plot_degree_distribution(degree_list):
    dict_of_degree_to_number_of_nodes = dict()

    for degree in degree_list:
        if degree not in dict_of_degree_to_number_of_nodes:
            dict_of_degree_to_number_of_nodes[degree] = 0

        dict_of_degree_to_number_of_nodes[degree] += 1

    number_of_nodes = len(degree_list)
    x_axis_of_degree = list()
    y_axis_of_probability_of_degree = list()
    
    for degree in dict_of_degree_to_number_of_nodes:
        x_axis_of_degree.append(degree)
        y_axis_of_probability_of_degree.append(dict_of_degree_to_number_of_nodes[degree] / number_of_nodes)

    matplotlib.pyplot.figure()
    axis = matplotlib.pyplot.gca()
    axis.set_title(str(len(degree_list) - 1) + ' nodes')
    axis.set_xlabel('Node')
    axis.set_ylabel('Probability of degree k')
    axis.set_xscale('log')
    axis.set_yscale('log')
    matplotlib.pyplot.scatter(x_axis_of_degree, y_axis_of_probability_of_degree)

def q1a():
    g, d = get_initial_graph()
    look_out_for = [100, 1000, 10000]

    for index_of_node in range(4, 10001):
        g, d = get_graph_at_next_time_step(g, d, index_of_node)

        if index_of_node in look_out_for:
            plot_degree_distribution(d)

    matplotlib.pyplot.show()

def plot_dd_with_fit(degree_list):    
    fit = powerlaw.Fit(degree_list, xmin=4, discrete=True)
    alpha = fit.alpha * -1
    print('alpha is', alpha)

    x, y = powerlaw.pdf(degree_list, xmin=4, linear_bins=True, discrete=True)
    ind = y>0
    y = y[ind]
    x = x[:-1]
    x = x[ind]    
    gca = matplotlib.pyplot.gca()
    gca.set_title('1b: Degree distribution')
    gca.set_xlabel('Node')
    gca.set_ylabel('Probability of degree k')
    axis = fit.power_law.plot_pdf(degree_list)
    matplotlib.pyplot.scatter(x, y, label=str(len(degree_list) - 1) + ' nodes')
    gca.legend()

def q1b():
    g, d = get_initial_graph()
    look_out_for = [100, 1000, 10000]

    for index_of_node in range(4, 10001):
        g, d = get_graph_at_next_time_step(g, d, index_of_node)

        if index_of_node in look_out_for:
            plot_dd_with_fit(d)

    matplotlib.pyplot.show()

def plot_ddc_with_fit(degree_list):    
    fit = powerlaw.Fit(degree_list, xmin=4, discrete=True)
    alpha = fit.alpha * -1
    print('alpha is', alpha)

    x, y = powerlaw.ccdf(degree_list, xmin=4, linear_bins=True, discrete=True)
    axis = fit.power_law.plot_ccdf(degree_list)
    matplotlib.pyplot.scatter(x, y, label=str(len(degree_list) - 1) + ' nodes')
    gca = matplotlib.pyplot.gca()
    gca.set_title('1c: Degree distribution')
    gca.set_xlabel('Node')
    gca.set_ylabel('Probability of degree k')
    gca.legend()

def q1c():
    g, d = get_initial_graph()
    look_out_for = [100, 1000, 10000]

    for index_of_node in range(4, 10001):
        g, d = get_graph_at_next_time_step(g, d, index_of_node)

        if index_of_node in look_out_for:
            plot_ddc_with_fit(d)

    matplotlib.pyplot.show()

def graph_clustering_coefficient():
    matplotlib.pyplot.scatter(list_of_index_of_node, list_of_clustering_coefficients, label='Network')
    matplotlib.pyplot.plot(list_of_index_of_node, list_of_one_over_n, label='Random network')
    matplotlib.pyplot.plot(list_of_index_of_node, list_of_lnn_squared_over_n, label='B-A network')
    gca = matplotlib.pyplot.gca()
    gca.set_xlabel('Number of nodes')
    gca.set_ylabel('Average clustering coefficient')
    gca.set_xscale('log')
    gca.set_yscale('log')
    gca.legend()

def clustering_graph():
    list_of_index_of_node = list()
    list_of_clustering_coefficients = list()
    list_of_one_over_n = list()
    list_of_lnn_squared_over_n = list()
    time_step_skip = 1
    current_time_step = 0

    g, d = get_initial_graph()

    # while loop here...
    
    if current_time_step >= time_step_skip:
        current_time_step = 0
        time_step_skip += time_step_skip
        list_of_index_of_node.append(index_of_node)
        c = networkx.algorithms.cluster.average_clustering(graph)
        list_of_clustering_coefficients.append(c)
        list_of_one_over_n.append(1.0 / index_of_node)
        n = index_of_node + 1
        lnn_squared_over_n = (math.log(n) ** 2) / n
        list_of_lnn_squared_over_n.append(lnn_squared_over_n)
    else:
        current_time_step += 1    


def degree_dynamics():
    g, d = get_initial_graph()

    list_of_index_of_nodes = list()
    t_to_the_beta = list()
    dict_of_degree_dynamics_x = dict()
    dict_of_degree_dynamics_y = dict()
    time_step_skip = 30
    current_time_step = 0

    for index_of_node in range(4, 5000):
        g, d = get_graph_at_next_time_step(g, d, index_of_node)

        if current_time_step >= time_step_skip:
            current_time_step = 0
            time_step_skip += time_step_skip
            t_to_the_beta.append((index_of_node + 1) ** (1/2))
            list_of_index_of_nodes.append(index_of_node)
            dict_of_degree_dynamics_x[index_of_node] = list()
            dict_of_degree_dynamics_y[index_of_node] = list()
                        
            for who_to_watch in list_of_index_of_nodes:
                dict_of_degree_dynamics_x[who_to_watch].append(index_of_node)
                degree_of_node = networkx.degree(g, who_to_watch)
                dict_of_degree_dynamics_y[who_to_watch].append(degree_of_node)
        else:
            current_time_step += 1

    # Degree dynamics calculated. Now graph it.

    for index_of_node in list_of_index_of_nodes:
        matplotlib.pyplot.plot(dict_of_degree_dynamics_x[index_of_node],
                               dict_of_degree_dynamics_y[index_of_node])

    matplotlib.pyplot.plot(list_of_index_of_nodes, t_to_the_beta, '--', label='Dynamical exponent')

    gca = matplotlib.pyplot.gca()
    gca.set_xlabel('Node')
    gca.set_ylabel('Degree')
    gca.set_xscale('log')
    gca.set_yscale('log')
    gca.legend()

    matplotlib.pyplot.show()
    
def main():
    q1c()

if __name__ == '__main__':
    main()
