# search.py
# ---------
# Licensing Information:  You are free to use or extend these projects for
# educational purposes provided that (1) you do not distribute or publish
# solutions, (2) you retain this notice, and (3) you provide clear
# attribution to UC Berkeley, including a link to http://ai.berkeley.edu.
# 
# Attribution Information: The Pacman AI projects were developed at UC Berkeley.
# The core projects and autograders were primarily created by John DeNero
# (denero@cs.berkeley.edu) and Dan Klein (klein@cs.berkeley.edu).
# Student side autograding was added by Brad Miller, Nick Hay, and
# Pieter Abbeel (pabbeel@cs.berkeley.edu).


"""
In search.py, you will implement generic search algorithms which are called by
Pacman agents (in searchAgents.py).
"""

import util

class SearchProblem:
    """
    This class outlines the structure of a search problem, but doesn't implement
    any of the methods (in object-oriented terminology: an abstract class).

    You do not need to change anything in this class, ever.
    """

    def getStartState(self):
        """
        Returns the start state for the search problem.
        """
        util.raiseNotDefined()

    def isGoalState(self, state):
        """
          state: Search state

        Returns True if and only if the state is a valid goal state.
        """
        util.raiseNotDefined()

    def getSuccessors(self, state):
        """
          state: Search state

        For a given state, this should return a list of triples, (successor,
        action, stepCost), where 'successor' is a successor to the current
        state, 'action' is the action required to get there, and 'stepCost' is
        the incremental cost of expanding to that successor.
        """
        util.raiseNotDefined()

    def getCostOfActions(self, actions):
        """
         actions: A list of actions to take

        This method returns the total cost of a particular sequence of actions.
        The sequence must be composed of legal moves.
        """
        util.raiseNotDefined()


def tinyMazeSearch(problem):
    """
    Returns a sequence of moves that solves tinyMaze.  For any other maze, the
    sequence of moves will be incorrect, so only use this for tinyMaze.
    """
    from game import Directions
    s = Directions.SOUTH
    w = Directions.WEST
    return  [s, s, w, s, w, w, s, w]

def depthFirstSearch(problem):
    """
    Search the deepest nodes in the search tree first.

    Your search algorithm needs to return a list of actions that reaches the
    goal. Make sure to implement a graph search algorithm.

    To get started, you might want to try some of these simple commands to
    understand the search problem that is being passed in:

    print("Start:", problem.getStartState())
    print("Is the start a goal?", problem.isGoalState(problem.getStartState()))
    print("Start's successors:", problem.getSuccessors(problem.getStartState()))
    """

    listofactions = list()

    # Let's define a search node as (state, path, seen) for
    # ourselves. From searchAgents. It is necessary to define a path
    # as a list of Directions. Define seen as a set of states that the
    # path traverses. For example [Directions.WEST] and so on.

    # This algorithm is straightforward except for the code that
    # handles loopy paths. We assume that loopy paths cannot happen,
    # and therefore no state can be traversed twice. Then, avoiding
    # loopy paths is easy. Just check if the state is in a set that we
    # maintain for each search node. The reason you see such quirky
    # set behavior is because python prefers to decompose the state
    # tuple (x,y) which is not much of a problem.

    from util import Stack
    stack_of_searchnode = Stack()
    stack_of_searchnode.push((problem.getStartState(), []))    
    visited_states = set()
    visited_states.add(problem.getStartState())
    goal_path_here = list()

    while not stack_of_searchnode.isEmpty() and len(goal_path_here) == 0:
        leftmost_searchnode = stack_of_searchnode.pop()
        visited_states.add(leftmost_searchnode[0])

        if problem.isGoalState(leftmost_searchnode[0]):
            goal_path_here = leftmost_searchnode[1]
        else:
            # The state in the search node we're looking at is not at
            # the goal state, so continue searching down it. Make sure
            # to add the direction of the successor to the path of the
            # search node. If there are no successors to a search
            # node, then getSuccessors will hopefully return an empty
            # list, and we'll traverse the next search nodes. For
            # example, we can search deep down a path, but then pop
            # into a shallow search node. Note that loopy paths are
            # possible as of this point.
            
            successor_states_of_next = problem.getSuccessors(leftmost_searchnode[0])
            
            for successor in successor_states_of_next:
                new_path_with_direction_added = leftmost_searchnode[1] + [successor[1]]

                # We can check for a loopy path before we push the
                # search node, or after we pop the search node. Let's
                # nip it earlier rather than later.                

                if successor[0] not in visited_states:
                    new_searchnode_to_search_down = (successor[0],
                                                     new_path_with_direction_added)
                    stack_of_searchnode.push(new_searchnode_to_search_down)

    return goal_path_here
    

def breadthFirstSearch(problem):
    """Search the shallowest nodes in the search tree first."""

    # This one will duplicate code from Q1, and use slightly less
    # documentation than it.

    listofactions = list()

    from util import Queue
    stack_of_searchnode = Queue()
    visited_states = set()
    visited_states.add(problem.getStartState())
    stack_of_searchnode.push((problem.getStartState(), []))
    goal_path_here = list()

    while not stack_of_searchnode.isEmpty() and len(goal_path_here) == 0:
        leftmost_searchnode = stack_of_searchnode.pop()

        if problem.isGoalState(leftmost_searchnode[0]):
            goal_path_here = leftmost_searchnode[1]
        else:
            successor_states_of_next = problem.getSuccessors(leftmost_searchnode[0])
            
            for successor in successor_states_of_next:
                new_path_with_direction_added = leftmost_searchnode[1] + [successor[1]]

                if successor[0] not in visited_states:
                    visited_states.add(successor[0])
                    new_searchnode_to_search_down = (successor[0],
                                                     new_path_with_direction_added)
                    stack_of_searchnode.push(new_searchnode_to_search_down)

    return goal_path_here

def uniformCostSearch(problem):
    """Search the node of least total cost first."""

    # This one will duplicate code from Q1, and use slightly less
    # documentation than it.

    listofactions = list()

    from util import PriorityQueue
    stack_of_searchnode = PriorityQueue()
    
    visited_states = set()
    visited_states.add(problem.getStartState())

    initial_path = list()
    initial_g = 0

    for successor in problem.getSuccessors(problem.getStartState()):
        visited_states.add(successor[0])
        stack_of_searchnode.push((successor[0],
                                  initial_path + [successor[1]],
                                  initial_g + successor[2]),
                                 successor[2])

    goal_path_here = list()

    while not stack_of_searchnode.isEmpty() and len(goal_path_here) == 0:
        leftmost_searchnode = stack_of_searchnode.pop()

        if problem.isGoalState(leftmost_searchnode[0]):
            goal_path_here = leftmost_searchnode[1]
        else:
            successor_states_of_next = problem.getSuccessors(leftmost_searchnode[0])
            
            for successor in successor_states_of_next:
                new_path_with_direction_added = leftmost_searchnode[1] + [successor[1]]

                if successor[0] not in visited_states:
                    visited_states.add(successor[0])
                    new_g = leftmost_searchnode[2] + successor[2]
                    new_searchnode_to_search_down = (successor[0],
                                                     new_path_with_direction_added,
                                                     new_g)
                    stack_of_searchnode.push(new_searchnode_to_search_down,
                                             new_g)

    return goal_path_here    


def nullHeuristic(state, problem=None):
    """
    A heuristic function estimates the cost from the current state to the nearest
    goal in the provided SearchProblem.  This heuristic is trivial.
    """
    return 0

def aStarSearch(problem, heuristic=nullHeuristic):
    """Search the node that has the lowest combined cost and heuristic first."""

    listofactions = list()

    from util import PriorityQueue
    stack_of_searchnode = PriorityQueue()
    
    visited_states = set()
    visited_states.add(problem.getStartState())

    initial_path = list()
    initial_g = 0

    for successor in problem.getSuccessors(problem.getStartState()):
        visited_states.add(successor[0])
        initial_f = initial_g + heuristic(successor[0], problem)
        stack_of_searchnode.push((successor[0],
                                  initial_path + [successor[1]],
                                  initial_g + successor[2]),
                                 initial_f)

    goal_path_here = list()

    while not stack_of_searchnode.isEmpty() and len(goal_path_here) == 0:
        leftmost_searchnode = stack_of_searchnode.pop()

        if problem.isGoalState(leftmost_searchnode[0]):
            goal_path_here = leftmost_searchnode[1]
        else:
            successor_states_of_next = problem.getSuccessors(leftmost_searchnode[0])
            
            for successor in successor_states_of_next:
                new_path_with_direction_added = leftmost_searchnode[1] + [successor[1]]

                if successor[0] not in visited_states:
                    visited_states.add(successor[0])
                    new_g = leftmost_searchnode[2] + successor[2]
                    new_h = heuristic(successor[0], problem)
                    new_f = new_g + new_h

                    new_searchnode_to_search_down = (successor[0],
                                                     new_path_with_direction_added,
                                                     new_g)

                    stack_of_searchnode.push(new_searchnode_to_search_down,
                                             new_f)

    return goal_path_here    


# Abbreviations
bfs = breadthFirstSearch
dfs = depthFirstSearch
astar = aStarSearch
ucs = uniformCostSearch
