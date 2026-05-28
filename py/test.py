import unittest

# Der einfachste Test.
# python test.py

class Test(unittest.TestCase):
    def test(self):
        self.assertEqual(true, 1 in [1,2,3,4])

if __name__ == '__main__':
    unittest.main()
