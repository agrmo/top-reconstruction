# multiAgents.py
# --------------
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


from util import manhattanDistance
from game import Directions
import random, util

from game import Agent

# Agustin: Hello and welcome to PA2.

def euclidean(x1, y1, x2, y2):
    return ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** 0.5

class ReflexAgent(Agent):
    """
    A reflex agent chooses an action at each choice point by examining
    its alternatives via a state evaluation function.

    The code below is provided as a guide.  You are welcome to change
    it in any way you see fit, so long as you don't touch our method
    headers.
    """


    def getAction(self, gameState):
        """
        You do not need to change this method, but you're welcome to.

        getAction chooses among the best options according to the evaluation function.

        Just like in the previous project, getAction takes a GameState and returns
        some Directions.X for some X in the set {NORTH, SOUTH, WEST, EAST, STOP}
        """
        # Collect legal moves and successor states
        legalMoves = gameState.getLegalActions()

        # Choose one of the best actions
        scores = [self.evaluationFunction(gameState, action) for action in legalMoves]
        bestScore = max(scores)
        bestIndices = [index for index in range(len(scores)) if scores[index] == bestScore]
        chosenIndex = random.choice(bestIndices) # Pick randomly among the best

        "Add more of your code here if you want to"

        return legalMoves[chosenIndex]

    def evaluationFunction(self, currentGameState, action):
        """
        Design a better evaluation function here.

        The evaluation function takes in the current and proposed successor
        GameStates (pacman.py) and returns a number, where higher numbers are better.

        The code below extracts some useful information from the state, like the
        remaining food (newFood) and Pacman position after moving (newPos).
        newScaredTimes holds the number of moves that each ghost will remain
        scared because of Pacman having eaten a power pellet.

        Print out these variables to see what you're getting, then combine them
        to create a masterful evaluation function.
        """
        # Useful information you can extract from a GameState (pacman.py)
        successorGameState = currentGameState.generatePacmanSuccessor(action)
        newPos = successorGameState.getPacmanPosition()
        newFood = successorGameState.getFood()
        newGhostStates = successorGameState.getGhostStates()
        newScaredTimes = [ghostState.scaredTimer for ghostState in newGhostStates]

        # Return a constant, except for when a ghost is within 3
        # euclidean units away. When a constant is returned, the
        # caller will move the pacman randomly. When a ghost is within
        # 3 euclideans, return a number that moves it farthest away
        # from the closest ghost..

        gpositions = successorGameState.getGhostPositions()
        curpacx, curpacy = currentGameState.getPacmanPosition()
        newpacx, newpacy = newPos

        a_ghost_is_within_three_euclideans = False

        for gposition in gpositions:
            ghostx, ghosty = gposition

            if euclidean(ghostx, ghosty, curpacx, curpacy) < 3:
                a_ghost_is_within_three_euclideans = True

                
        if not a_ghost_is_within_three_euclideans:
            print('returning 0 for move', action)
            return 0
        else:
            closest_ghostx, closest_ghosty = gpositions[0]

            for maybe_closest_ghost in gpositions:
                maybe_closest_ghostx, maybe_closest_ghosty = maybe_closest_ghost

                if euclidean(curpacx, curpacy, maybe_closest_ghostx, maybe_closest_ghosty) < euclidean(curpacx, curpacy, closest_ghostx, closest_ghosty):
                    closest_ghostx = maybe_closest_ghostx
                    closest_ghosty = maybe_closest_ghosty

            print('returning', euclidean(newpacx, newpacy, closest_ghostx, closest_ghosty), 'for move', action)
            return euclidean(newpacx, newpacy, closest_ghostx, closest_ghosty)
                    
        return evaluationfunction

def scoreEvaluationFunction(currentGameState):
    """
    This default evaluation function just returns the score of the state.
    The score is the same one displayed in the Pacman GUI.

    This evaluation function is meant for use with adversarial search agents
    (not reflex agents).
    """
    return currentGameState.getScore()

class MultiAgentSearchAgent(Agent):
    """
    This class provides some common elements to all of your
    multi-agent searchers.  Any methods defined here will be available
    to the MinimaxPacmanAgent, AlphaBetaPacmanAgent & ExpectimaxPacmanAgent.

    You *do not* need to make any changes here, but you can if you want to
    add functionality to all your adversarial search agents.  Please do not
    remove anything, however.

    Note: this is an abstract class: one that should not be instantiated.  It's
    only partially specified, and designed to be extended.  Agent (game.py)
    is another abstract class.
    """

    def __init__(self, evalFn = 'scoreEvaluationFunction', depth = '2'):
        self.index = 0 # Pacman is always agent index 0
        self.evaluationFunction = util.lookup(evalFn, globals())
        self.depth = int(depth)

def maxs_turn(current_depth, agent, gamestate, min_layers):
    if gamestate.isWin() or gamestate.isLose() or current_depth == agent.depth:
        return agent.evaluationFunction(gamestate)

    # Not at terminal state. Need to ask min.
    what_directions_sir = gamestate.getLegalActions()
    value = mins_turn(current_depth, agent, gamestate.generateSuccessor(0, what_directions_sir[0]), min_layers, min_layers - 1)

    for direction in what_directions_sir:
        value_from_min = mins_turn(current_depth, agent, gamestate.generateSuccessor(0, direction), min_layers, min_layers - 1)

        if value_from_min > value:
            value = value_from_min
            # print('max: best is', value, 'for dir', direction)

    return value

def mins_turn(current_depth, agent, gamestate, min_layers, how_many_more_min_layers):
    if gamestate.isWin() or gamestate.isLose() or current_depth == agent.depth:
        return agent.evaluationFunction(gamestate)

    # Not at terminal state. Need to ask the next layer.
    what_directions_sir = gamestate.getLegalActions()
    value = 1234

    if how_many_more_min_layers > 0:
        value = mins_turn(current_depth, agent, gamestate.generateSuccessor(0, what_directions_sir[0]), min_layers, how_many_more_min_layers - 1)
    else:
        value = maxs_turn(current_depth + 1, agent, gamestate.generateSuccessor(0, what_directions_sir[0]), min_layers)

    for direction in what_directions_sir:
        if how_many_more_min_layers > 0:
            value_from_min = mins_turn(current_depth, agent, gamestate.generateSuccessor(0, direction), min_layers, how_many_more_min_layers - 1)

            if value_from_min < value:
                value = value_from_min

        else:
            value_from_max = maxs_turn(current_depth + 1, agent, gamestate.generateSuccessor(0, direction), min_layers)

            if value_from_max < value:
                value = value_from_max

    return value

class MinimaxAgent(MultiAgentSearchAgent):
    """
    Your minimax agent (question 2)
    """

    def getAction(self, gameState):
        """
        Returns the minimax action from the current gameState using self.depth
        and self.evaluationFunction.

        Here are some method calls that might be useful when implementing minimax.

        gameState.getLegalActions(agentIndex):
        Returns a list of legal actions for an agent
        agentIndex=0 means Pacman, ghosts are >= 1

        gameState.generateSuccessor(agentIndex, action):
        Returns the successor game state after an agent takes an action

        gameState.getNumAgents():
        Returns the total number of agents in the game

        gameState.isWin():
        Returns whether or not the game state is a winning state

        gameState.isLose():
        Returns whether or not the game state is a losing state
        """
        if gameState.isWin() or gameState.isLose():
            return self.evaluationFunction(gameState)
    
        # Not at terminal state. Need to ask min.
        what_directions_sir = gameState.getLegalActions()
        min_layers = gameState.getNumAgents() - 1
        current_depth = 0
        
        # Whenever it is max's turn, increment the depth. In other
        # words, each successive min layer is at the same depth, and
        # when min calls max, it increments the depth for max :)
        
        value = mins_turn(current_depth, self, gameState.generateSuccessor(0, what_directions_sir[0]), min_layers, min_layers - 1)
        direction_for_value = what_directions_sir[0]
    
        for direction in what_directions_sir:
            value_from_min = mins_turn(current_depth, self, gameState.generateSuccessor(0, direction), min_layers, min_layers - 1)
            print('max: got', value, 'for dir', direction)
    
            if value_from_min > value:
                value = value_from_min
                direction_for_value = direction

        print('moving', direction_for_value, 'for value', value)
        return direction_for_value
            

class AlphaBetaAgent(MultiAgentSearchAgent):
    """
    Your minimax agent with alpha-beta pruning (question 3)
    """

    def getAction(self, gameState):
        """
        Returns the minimax action using self.depth and self.evaluationFunction
        """
        "*** YOUR CODE HERE ***"
        util.raiseNotDefined()

class ExpectimaxAgent(MultiAgentSearchAgent):
    """
      Your expectimax agent (question 4)
    """

    def getAction(self, gameState):
        """
        Returns the expectimax action using self.depth and self.evaluationFunction

        All ghosts should be modeled as choosing uniformly at random from their
        legal moves.
        """
        "*** YOUR CODE HERE ***"
        util.raiseNotDefined()

def betterEvaluationFunction(currentGameState):
    """
    Your extreme ghost-hunting, pellet-nabbing, food-gobbling, unstoppable
    evaluation function (question 5).

    DESCRIPTION: <write something here so we know what you did>
    """
    "*** YOUR CODE HERE ***"
    util.raiseNotDefined()

# Abbreviation
better = betterEvaluationFunction
