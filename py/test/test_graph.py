import unittest
from graph.graph import Graph

# cd py
# python -m unittest discover test -v

class Test(unittest.TestCase):
    def test(self):
        g = Graph(5,[[0,1],[1,2],[3,4]])
        self.assertTrue(1 in g.nachbarliste[0])
