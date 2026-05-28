import unittest
import simple

class testS(unittest.TestCase):
	def testSanity(self):
		self.assertEqual(simple.sanity(), 4)

if __name__ == '__main__':
	unittest.main()
