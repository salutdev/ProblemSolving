from .tree_node import TreeNode

class Tree:
    @staticmethod
    def get_example_tree():
        root = TreeNode(20)
        root.left = TreeNode(15)
        root.right = TreeNode(25)
        return root