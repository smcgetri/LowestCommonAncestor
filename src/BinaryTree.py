# Python implementation to find lowest common ancestor of n1 and n2 using one traversal of binary tree

# Class containing left and right child of current node and key value
class Node:

    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


# returns pointer to LCA of two given values n1 and n2, assuming
# that n1 and n2 are present in Binary Tree
def findLCA(root, n1, n2):

    # Base Case
    if root is None:
        return None

    # If either n1 or n2 matches with root's key, report
    #  the presence by returning root (Note that if a key is
    #  ancestor of other, then the ancestor key becomes LCA
    if root.key == n1 or root.key == n2:
        return root

    # Look for keys in left and right subtrees
    left_lca = findLCA(root.left, n1, n2)
    right_lca = findLCA(root.right, n1, n2)

    # If both of the above calls return Non-NULL, then one key
    # is present in once subtree and other is present in other,
    # So this node is the LCA
    if left_lca and right_lca:
        return root

    # Otherwise check if left subtree or right subtree is LCA
    return left_lca if left_lca is not None else right_lca



