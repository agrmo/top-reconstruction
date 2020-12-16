class Expression:
    def __init__(self, operation, left, right):
        self.operation = operation
        self.left = left
        self.right = right

    def __iter__(self):
        self.queue = list()
        self.queue.append((list(), self))
        return self

    def __next__(self):
        if len(self.queue) == 0:
            raise StopIteration
        
        (path, pop) = self.queue.pop(0)

        if type(pop) is Expression:
            self.queue.append((path + ['l'], pop.left))
            self.queue.append((path + ['r'], pop.right))

        return (path, pop)

    def __str__(self):
        strep = self.operation + '('
        
        if type(self.left) is Expression:
            strep += self.left.__str__()
        else:
            strep += self.left

        strep += ','

        if type(self.right) is Expression:
            strep += self.right.__str__()
        else:
            strep += self.right

        strep += ')'

        return strep

    def __repr__(self):
        return self.__str__()


def str_to_expression(inputstring):
    initial = ''
    searching = False
    index_of_comma = 0
    depth = 0
    
    for index, char in enumerate(inputstring):
        if searching and char == ',':
            if depth == 0:
                index_of_comma = index
                break

        if searching and char == '(':
            depth += 1

        if searching and char == ')':
            depth -= 1

        if not searching and char == '(':
            searching = True

        if not searching:
            initial += char

    left = inputstring[len(initial)+1:index_of_comma]
    right = inputstring[index_of_comma+1:-1]

    if not searching:
        return initial
    else:
        return Expression(initial, str_to_expression(left), str_to_expression(right))

class Test:
    def __init__(self, start_state, goal_state, rules):
        self.start_state = start_state
        self.goal_state = goal_state
        self.rules = rules

    def __str__(self):
        outp = 'Test('
        outp += self.start_state.__str__() + ','
        outp += self.goal_state.__str__() + ',['
        for (lhs, rhs) in self.rules:
            outp += '[' + lhs.__str__() + ',' + rhs.__str__() + ']'

        outp += ']'
        return outp

    def __repr__(self):
        return self.__str__()

def get_test_set():
    f = open('test_set.txt')
    state_machine = 0
    test_set = set()
    start_state = None
    goal_state = None
    rules = list()
    rule_lhs = None
    
    for line in f:
        if state_machine == 0:
            if line == '\n':
                break
            
            start_state = str_to_expression(line.rstrip('\n'))
            state_machine = 1
            
        elif state_machine == 1:
            goal_state = str_to_expression(line.rstrip('\n'))
            state_machine = 2

        elif state_machine == 2:
            if line == '\n':
                test_set.add(Test(start_state, goal_state, rules))
                rules = list()
                state_machine = 0
            else:
                rule_lhs = str_to_expression(line.rstrip('\n'))
                state_machine = 3

        elif state_machine == 3:
            rule_rhs = str_to_expression(line.rstrip('\n'))
            rules.append([rule_lhs, rule_rhs])
            state_machine = 2

    return test_set


def is_equal(expression_a, expression_b):
    if type(expression_a) is Expression and type(expression_b) is Expression:
        expression_a_operation = expression_a.operation
        expression_a_left = expression_a.left
        expression_a_right = expression_a.right

        expression_b_operation = expression_b.operation
        expression_b_left = expression_b.left
        expression_b_right = expression_b.right

        operations_equal = expression_a_operation == expression_b_operation
        left_equal = is_equal(expression_a_left, expression_b_left)
        right_equal = is_equal(expression_a_right, expression_b_right)

        return operations_equal and left_equal and right_equal

    if type(expression_a) is not Expression and type(expression_b) is not Expression:
        return expression_a == expression_b

    return False    


def replace(expression, subexpression, path):
    if len(path) == 0:
        return subexpression

    pop = path.pop(0)

    if pop == 'l':
        return Expression(expression.operation, replace(expression.left, subexpression, path), expression.right)

    if pop == 'r':
        return Expression(expression.operation, expression.left, replace(expression.right, subexpression, path))

    # Shouldn't be here.

    
# def get_cost(expression, (lhs, rhs)):
#     pass
    
def get_successors(expression, rules):
    successors = list()
    
    for lhs, rhs in rules:
        if type(expression) is Expression:
            for (path, subexpression) in expression:
                if is_equal(lhs, subexpression):
                    successor = replace(expression, rhs, path)
                    successors.append(successor)
                    
                if is_equal(rhs, subexpression):
                    successor = replace(expression, lhs, path)
                    successors.append(successor)
        else:
            if is_equal(lhs, expression):
                successors.append(rhs)

            if is_equal(rhs, expression):
                successors.append(lhs)
                
    return successors


def bfs(start_state, goal_state, rules):
    queue = list()
    queue.append((list(), start_state))
    max_depth = 7
    
    while len(queue) != 0:
        (path, pop_state) = queue.pop(0)

        if is_equal(pop_state, goal_state):
            return (True, path + [pop_state])

        if len(path) < max_depth:
            successors = get_successors(pop_state, rules)

            for successor in successors:
                queue.append((path + [pop_state], successor))

    return (False, list())


def dfs(start_state, goal_state, rules):
    queue = list()
    queue.append((list(), start_state))
    max_depth = 7
    
    while len(queue) != 0:
        (path, pop_state) = queue.pop()

        if is_equal(pop_state, goal_state):
            return (True, path + [pop_state])

        if len(path) < max_depth:
            successors = get_successors(pop_state, rules)

            for successor in successors:
                queue.append((path + [pop_state], successor))

    return (False, list())


def test_bfs():
    test_set = get_test_set()
    result_list = list()
    
    for test in test_set:
        search_result = bfs(test.start_state,
                            test.goal_state,
                            test.rules)
        result_list.append((test, search_result))

    solutions_found = 0
    tests_that_failed = list()

    for (test, (gotsolution, path)) in result_list:
        if gotsolution:
            solutions_found += 1
        else:
            tests_that_failed.append(test)

    print('BFS:')
    print('Found', solutions_found, 'solutions from', len(test_set), 'tests.')
    print('Tests that failed:')
    print()
            
    for test in tests_that_failed:
        print('Start:', test.start_state)
        print('Goal:', test.goal_state)
        print('Rules:', test.rules)
        print()

def test_dfs():
    test_set = get_test_set()
    result_list = list()
    
    for test in test_set:
        search_result = dfs(test.start_state,
                            test.goal_state,
                            test.rules)
        result_list.append((test, search_result))

    solutions_found = 0
    tests_that_failed = list()

    for (test, (gotsolution, path)) in result_list:
        if gotsolution:
            solutions_found += 1
        else:
            tests_that_failed.append(test)

    print('DFS:')
    print('Found', solutions_found, 'solutions from', len(test_set), 'tests.')
    print('Tests that failed:')
    print()
            
    for test in tests_that_failed:
        print('Start:', test.start_state)
        print('Goal:', test.goal_state)
        print('Rules:', test.rules)
        print()
        

        
def main():
    test_bfs()
    test_dfs()

if __name__ == '__main__':
    main()
