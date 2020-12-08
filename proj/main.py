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

exp = str_to_expression('add(a,add(a,b))')
print(exp)

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

    
def get_successors(expression, rules):
    successors = list()
    
    for lhs, rhs in rules:
        for (path, subexpression) in expression:
            if is_equal(lhs, subexpression):
                successor = replace(expression, rhs, path)
                successors.append(successor)

            if is_equal(rhs, subexpression):
                successor = replace(expression, lhs, path)
                successors.append(successor)
            
    return successors

    
class Agent:
    def __init__(self, start_state, goal_state, rules):
        self.start_state = start_state
        self.goal_state = goal_state
        self.rules = rules

class BreadthFirstSearchAgent(Agent):
    def is_equal(self):
        queue = list()
        queue.append((list(), self.start_state))
        max_depth = 7
        
        while len(queue) != 0:
            (path, pop_state) = queue.pop(0)

            if is_equal(pop_state, self.goal_state):
                return (True, path + [pop_state])

            if len(path) < max_depth:
                successors = get_successors(pop_state, self.rules)

                for successor in successors:
                    queue.append((path + [pop_state], successor))

        return (False, list())
    

class DepthFirstSearchAgent(Agent):
    def is_equal(self):
        stack = list()
        stack.append((list(), self.start_state))
        max_depth = 7
        
        while len(stack) != 0:
            (path, pop_state) = stack.pop()

            if is_equal(pop_state, self.goal_state):
                return (True, path + [pop_state])

            if len(path) < max_depth:
                successors = get_successors(pop_state, self.rules)

                for successor in successors:
                    stack.append((path + [pop_state], successor))

        return (False, list())
    


def main():
    start_state = Expression('add', 'a', Expression('add', 'a', 'b'))
    goal_state = Expression('add', 'a', 'e')
    
    rules = [[Expression('add', 'a', 'b'), 'c'], ['c', Expression('add', 'a', 'b')], [Expression('add', 'a', 'b'), 'e']]
    
    agent = BreadthFirstSearchAgent(start_state, goal_state, rules)
    is_equal = agent.is_equal()
    print(is_equal)


if __name__ == '__main__':
    main()
