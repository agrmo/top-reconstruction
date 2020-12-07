class Expression():
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
        
        return pop
    
# An Expression is one of Expression, Symbol.

class Problem:
    def __init__(self, start_state, goal_state, rules):
        self.current_state = start_state
        self.goal_state = goal_state
        self.rules = rules


    def get_possible_actions(self):
        possible_actions = list()
        
        current_expansion = [e for e in self.current_state]
    
        for lhs, rhs in self.rules:
            print('lhs', lhs, 'rhs', rhs)
            for sublist in zip(*[iter(current_expansion)]*len(lhs)):
                fix_list = list()
    
                for tuplething in sublist:
                    fix_list.append(tuplething)
    
                if fix_list == lhs:
                    possible_actions.append((lhs, rhs))
    
            for sublist in zip(*[iter(current_expansion)]*len(rhs)):
                if sublist == rhs:
                    possible_actions.append([rhs, lhs])                
                    
        return possible_actions

    def goal_test(self):
        current_expansion = [e for e in self.current_state]
        goal_expansion = [e for e in self.goal_state]
        return current_expansion == goal_expansion
    
    def take_action(self, action):
        pass

def main():
    start_state = 'a'
    goal_state = 'b'
    rules = [[['a'], ['b']], [['a'], ['c']]]
    
    problem = Problem(start_state, goal_state, rules)

    actions = problem.get_possible_actions()

    print(actions)

if __name__ == '__main__':
    main()
