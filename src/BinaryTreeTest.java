import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    public void testEmptyTree() {
        BinaryTree tree = new BinaryTree();
        assertNull(tree.findLCA(0, 0));
    }

    @Test
    public void testTreeWithOneNode() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        assertEquals(1, tree.findLCA(1,1).data);
    }

    @Test
    public void testTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        assertEquals(1, tree.findLCA(2,3).data);
    }

    @Test
    public void testLeftTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(3);
        assertEquals(2, tree.findLCA(2,3).data);
    }

    @Test
    public void testRightTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(3);
        assertEquals(2, tree.findLCA(2,3).data);
    }

    @Test
    public void testSubTreeLeft() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        assertEquals(2, tree.findLCA(4,5).data);
    }

    @Test
    public void testSubTreeRight() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        assertEquals(3, tree.findLCA(6,7).data);
    }

    @Test
    public void testWithNegatives() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(-1);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(-3);
        tree.root.left.left = new Node(-4);
        tree.root.left.right = new Node(-5);
        tree.root.right.left = new Node(-6);
        tree.root.right.right = new Node(-7);
        assertEquals(-3, tree.findLCA(-6,-7).data);
    }
}
