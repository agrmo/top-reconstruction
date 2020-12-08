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
