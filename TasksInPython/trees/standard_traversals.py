from .model.tree import Tree
import random
from trees.model.tree_node import TreeNode


class StandardTraversals:

    def calc():
        traversal = StandardTraversals()
        traversal.inorder_traversal()

        print(random.choice([12, 7, 3, 8]))

        my_list = [1, 2, 3, 4, 5]
        random.shuffle(my_list)
        print(my_list)

        node1 = TreeNode(59)
        node2 = TreeNode(43)
        node3 = TreeNode(21)

        nodes1 = [node1, node2, node3]
        nodes2 = nodes1
        nodes1[0].value = 44

        print('Nodes: ')
        [print(node.value) for node in nodes2]

    def inorder_traversal(self):
        root = Tree.get_example_tree()
        self.inorder_traversal_rec(root)

    def inorder_traversal_rec(self, root):
        if root is None:
            return

        self.inorder_traversal_rec(root.left)
        print(root.value)
        self.inorder_traversal_rec(root.right)
