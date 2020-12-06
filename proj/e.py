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

        if type(pop) is not Symbol:
            self.stack.append(pop.right)
            self.stack.append(pop.left)
            return pop.operation

        return pop.symbol
    
class Symbol(Expression):
    def __init__(self, symbol):
        self.symbol = symbol

    def __iter__(self):
        return self.symbol
    
    def __next__(self):
        return self.symbol

a = Symbol('a')
b = Symbol('b')
c = Expression('add', Expression('add', Symbol('b'), Symbol('c')), Expression('add', a, b))
d = [e for e in c]
print(d)
