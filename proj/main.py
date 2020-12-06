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

    
def add_operation(first_expression, second_expression):
    return Add(first_expression, second_expression)

def multiply_operation(first_expression, second_expression):
    return Multiply(first_expression, second_expression)

# An expression is one of Expression, Symbol.

def get_action(current_expression, target_expression):
    pass
    
def take_action(current_expression, first_expression, second_expression, operation):
    pass

def unwrap(expression):
    return (expression.first_expression, expression.second_expression)

def goal_test(current_expression, target_expression):
    # add(a, b) add(b, a) => False
    # add(a, b) add(a, b) => True

    current_expansion = [e for e in current_expression]
    target_expansion = [e for e in target_expression]

    return current_expansion == target_expansion

def read_expression():
    return Expression('add', 'b', 'a'), Expression('add', 'a', 'b')
    pass

def main():
    first_expression, second_expression = read_expression()
    print(goal_test(first_expression, second_expression))
    

if __name__ == '__main__':
    main()
