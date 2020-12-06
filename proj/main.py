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

def get_possible_actions(current_expression, rules):
    possible_actions = list()
    
    current_expansion = [e for e in current_expression]

    for lhs, rhs in rules:
        print('lhs', lhs, 'rhs', rhs)
        for sublist in zip(*[iter(current_expansion)]*len(lhs)):
            fix_list = list()

            for tuplething in sublist:
                fix_list.append(tuplething)

            if fix_list == lhs:
                possible_actions.append((lhs, rhs))

        for sublist in zip(*[iter(current_expansion)]*len(rhs)):
            fix_list = list()

            for tuplething in sublist:
                fix_list.append(tuplething)

            if fix_list == rhs:
                possible_actions.append((rhs, lhs))                
                
    return possible_actions
    
def get_action(current_expression, target_expression):
    pass
    
def take_action():
    pass

def goal_test(current_expression, target_expression):
    current_expansion = [e for e in current_expression]
    target_expansion = [e for e in target_expression]
    return current_expansion == target_expansion

def get_start_state():
    return 'a', 'b'

def get_rules():
    rules = list()
    
    rules.append((['a'], ['a']))

    return rules
    
def main():
    start_expression, target_expression = get_start_state()
    rules = get_rules()

    possible_actions = get_possible_actions(start_expression, rules)

    print(possible_actions)

if __name__ == '__main__':
    main()
