class Expression:
    def __init__(self, operation, left, right):
        self.operation = operation
        self.left = left
        self.right = right

    def __iter__(self):
        self.stack = [self]
        return self

    def __next__(self):
        if len(self.stack) == 0:
            raise StopIteration
        
        pop = self.stack.pop()

        if type(pop) is Expression:
            self.stack.append(pop.right)
            self.stack.append(pop.left)
            return pop.operation

        if type(pop) is Symbol:
            return pop.symbol

class Symbol:
    def __init__(self, symbol):
        self.symbol = symbol

    def __iter__(self):
        self.itered = False
        return self

    def __next__(self):
        if self.itered:
            raise StopIteration

        self.itered = True
        return self.symbol

class Problem:    
    def get_actions(self, state, rules):
        actions = list()
        
        expansion = [e for e in state]

        for lhs, rhs in rules:
            lhs_expansion = [e for e in lhs]
            rhs_expansion = [e for e in rhs]
            
            for i in range(len(expansion)):
                if i + len(lhs_expansion) <= len(expansion):
                    maybe_match_lhs = expansion[i: i + len(lhs_expansion)]
                    if maybe_match_lhs == lhs_expansion:
                        actions.append([lhs, rhs])

                # if i + len(rhs) <= len(expansion):
                #     maybe_match_rhs = expansion[i: i + len(rhs)]
                #     if maybe_match_rhs == rhs:
                #         actions.append([rhs, lhs])
                
        return actions

    def get_successors(self, state, rules):
        successors = list()
        
        actions = self.get_actions(state, rules)

    def goal_test(self, state, goal_state):
        expansion = [e for e in state]
        goal_expansion = [e for e in goal_state]
        return expansion == goal_expansion


class Agent:
    def __init__(problem, start_state, goal_state, rules):
        self.problem = problem
        self.start_state = start_state
        self.goal_state = goal_state
        self.rules = rules

class BreadthFirstSearchAgent(Agent):
    def is_equal():
        stack = list()
        stack.append(self.start_state)
        max_depth = 7
        
        while len(stack) != 0:
            (pop_state, depth) = stack.pop()

            if self.problem.goal_test(pop_state, self.goal_state):
                return True

            if depth < max_depth:
                depth += 1


def main():
    start_state = Expression('add', Symbol('a'), Symbol('b'))
    goal_state = Expression('add', Symbol('c'), Symbol('d'))
    rules = [[Symbol('a'), Symbol('b')], [Symbol('b'), Symbol('c')]]
    problem = Problem()
    # agent = Agent(problem, start_state, goal_state, rules)
    print(problem.get_actions(start_state, rules))


if __name__ == '__main__':
    main()
