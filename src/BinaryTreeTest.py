import unittest
import BinaryTree


class MyTestCase(unittest.TestCase):
    BinaryTree.root = BinaryTree.Node(1)
    BinaryTree.root.left = BinaryTree.Node(2)
    BinaryTree.root.right = BinaryTree.Node(3)
    BinaryTree.root.left.left = BinaryTree.Node(4)
    BinaryTree.root.left.right = BinaryTree.Node(5)
    BinaryTree.root.right.left = BinaryTree.Node(6)
    BinaryTree.root.right.right = BinaryTree.Node(7)

    def test_node4_5(self):
        self.assertEqual(BinaryTree.findLCA(BinaryTree.root, 4, 5).key, 2)

    def test_node6_2(self):
        self.assertEqual(BinaryTree.findLCA(BinaryTree.root, 4, 6).key, 1)

    def test_node1_5(self):
        self.assertEqual(BinaryTree.findLCA(BinaryTree.root, 3, 4).key, 1)

    def test_node_same(self):
        self.assertEqual(BinaryTree.findLCA(BinaryTree.root, 2, 4).key, 2)

    def test_node2_3(self):
        self.assertEqual(BinaryTree.findLCA(BinaryTree.root, 7, 4).key, 1)

    def test_node_none(self):
        self.assertEqual(BinaryTree.findLCA(None, 4, 5), None)

    def test_node_fake(self):
        self.assertEqual(BinaryTree.findLCA(BinaryTree.root, 8, 8), None)


if __name__ == '__main__':
    unittest.main()
