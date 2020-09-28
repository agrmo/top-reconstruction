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

    from game import Directions
    from util import Stack

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

    stack_of_searchnode = Stack()
    initial_path = list()
    initial_seen = set()
    initial_seen.add(problem.getStartState())

    for successor in problem.getSuccessors(problem.getStartState()):
        initial_seen_with_successor_state = initial_seen.copy()
        initial_seen_with_successor_state.add(successor[0])
        stack_of_searchnode.push((successor[0],
                                  initial_path + [successor[1]],
                                  initial_seen_with_successor_state))


        
    goal_path_here = list()

    while not stack_of_searchnode.isEmpty() and len(goal_path_here) == 0:
        leftmost_searchnode = stack_of_searchnode.pop()

        if problem.isGoalState(leftmost_searchnode[0]):
            goal_path_here = leftmost_searchnode[1]
        else:
            # The search node we're looking at is not at the goal
            # state, so continue searching down it. Make sure to add
            # the direction of the successor to the path so far. If
            # there are no successors to a search node, then
            # getSuccessors will hopefully return an empty list, and
            # we'll traverse the next search nodes. For example, we
            # can search deep down a path, but then pop into a shallow
            # search node. Note that loopy paths are possible.
            
            successor_states_of_next = problem.getSuccessors(leftmost_searchnode[0])
            
            for successor in successor_states_of_next:
                new_path_with_direction_added = leftmost_searchnode[1] + [successor[1]]
                print('trying path', new_path_with_direction_added)

                # We can check for a loopy path before we push the
                # search node, or after we pop the search node. Let's
                # nip it earlier rather than later.

                if successor[0] not in leftmost_searchnode[2]:
                    new_seen_with_successor_state = leftmost_searchnode[2].copy()
                    new_seen_with_successor_state.add(successor[0])
                    new_searchnode_to_search_down = (successor[0],
                                                     new_path_with_direction_added,
                                                     new_seen_with_successor_state)
                    print('adding ', new_searchnode_to_search_down)
                    stack_of_searchnode.push(new_searchnode_to_search_down)

    return goal_path_here

def breadthFirstSearch(problem):
    """Search the shallowest nodes in the search tree first."""

    # This one will duplicate code from Q1, and use slightly less
    # documentation than it.

    listofactions = list()

    from game import Directions
    from util import Queue

    stack_of_searchnode = Queue()
    initial_path = list()
    initial_seen = set()
    initial_seen.add(problem.getStartState())

    for successor in problem.getSuccessors(problem.getStartState()):
        initial_seen_with_successor_state = initial_seen.copy()
        initial_seen_with_successor_state.add(successor[0])
        stack_of_searchnode.push((successor[0],
                                  initial_path + [successor[1]],
                                  initial_seen_with_successor_state))


        
    goal_path_here = list()

    while not stack_of_searchnode.isEmpty() and len(goal_path_here) == 0:
        leftmost_searchnode = stack_of_searchnode.pop()

        if problem.isGoalState(leftmost_searchnode[0]):
            goal_path_here = leftmost_searchnode[1]
        else:
            successor_states_of_next = problem.getSuccessors(leftmost_searchnode[0])
            
            for successor in successor_states_of_next:
                new_path_with_direction_added = leftmost_searchnode[1] + [successor[1]]
                print('trying path', new_path_with_direction_added)

                if successor[0] not in leftmost_searchnode[2]:
                    new_seen_with_successor_state = leftmost_searchnode[2].copy()
                    new_seen_with_successor_state.add(successor[0])
                    new_searchnode_to_search_down = (successor[0],
                                                     new_path_with_direction_added,
                                                     new_seen_with_successor_state)
                    print('adding ', new_searchnode_to_search_down)
                    stack_of_searchnode.push(new_searchnode_to_search_down)

    return goal_path_here    

def uniformCostSearch(problem):
    """Search the node of least total cost first."""

    # This one will duplicate code from Q1, and use slightly less
    # documentation than it.
    
    util.raiseNotDefined()

def nullHeuristic(state, problem=None):
    """
    A heuristic function estimates the cost from the current state to the nearest
    goal in the provided SearchProblem.  This heuristic is trivial.
    """
    return 0

def aStarSearch(problem, heuristic=nullHeuristic):
    """Search the node that has the lowest combined cost and heuristic first."""
    "*** YOUR CODE HERE ***"
    util.raiseNotDefined()


# Abbreviations
bfs = breadthFirstSearch
dfs = depthFirstSearch
astar = aStarSearch
ucs = uniformCostSearch
