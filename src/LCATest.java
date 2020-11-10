import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

class LCATest {

    @Test
    public void testEmptyTree() {
        LCA tree = new LCA();
        assertNull(tree.findLCA(0, 0));
    }

    @Test
    public void testTreeWithOneNode() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        assertEquals(1, tree.findLCA(1,1).data);
    }

    @Test
    public void testTree() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        assertEquals(1, tree.findLCA(2,3).data);
    }

    @Test
    public void testLeftTree() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(3);
        assertEquals(2, tree.findLCA(2,3).data);
    }

    @Test
    public void testRightTree() {
        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(3);
        assertEquals(2, tree.findLCA(2,3).data);
    }

    @Test
    public void testSubTreeLeft() {
        LCA tree = new LCA();
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
        LCA tree = new LCA();
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
        LCA tree = new LCA();
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
