
class Expression():
    def __iter__(self):
        return self

    def __next__(self):
        yielf left
        yield right
        yield self

class Add(Expression):
    def __init__(self, left, right):
        self.left = left
        self.right = right

class Multiply(Expression):
    def __init__(self, left, right):
        self.left = left
        self.right = right

class Subtract(Expression):
    def __init__(self, left, right):
        self.left = left
        self.right = right

class Symbol(Expression):
    def __init__(self, symbol):
        self.symbol = symbol

    def __next__(self):
        yield self.symbol

def add_operation(first_expression, second_expression):
    return Add(first_expression, second_expression)

def multiply_operation(first_expression, second_expression):
    return Multiply(first_expression, second_expression)

# An expression is one of symbol, add, multiply.

def get_action(current_expression, target_expression):
    pass
    
def take_action(current_expression, first_expression, second_expression, operation):
    pass

def unwrap(expression):
    return (expression.first_expression, expression.second_expression)

def goal_test(current_expression, target_expression):
    # add(a, b) add(b, a) => False
    # add(a, b) add(a, b) => True

    if type(current_expression) is type(Symbol):
        if type(target_expression) is type(Symbol):
            if current_expression.get_symbol() == target_expression.get_symbol():
                return True
            else:
                return False
        else:
            return False

    if type(current_expression) is type(target_expression):
        cur_first, cur_second = unwrap(current_expression)
        tar_first, tar_second = unwrap(target_expression)

        first_eq = is_equal(cur_first, tar_first)
        second_eq = is_equal(cur_second, tar_second)
        
        return first_eq and second_eq


    return False

def read_expression():
    pass

def main():
    first_expression, second_expression = read_expression()
    print(goal_test(first_expression, second_expression))
    

if __name__ == '__main__':
    main()
