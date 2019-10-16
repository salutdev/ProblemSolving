package trees

class Tree {

    companion object ExampleTrees {

        public fun getExampleTree1(): TreeNode {
            /*                 20
             *              /      \
             *            13        44
             *           /  \      /   \
             *         4      17  25   58
             *        / \    / \    
             *       2   8  15 19  
             *      / \
 			 *     1   3
             */
            val root: TreeNode = TreeNode(20)
            root.left = TreeNode(13)
            root.right = TreeNode(44)

            root.left?.left = TreeNode(4)
            root.left?.right = TreeNode(17)

            root.left?.left?.left = TreeNode(2)
            root.left?.left?.right = TreeNode(8)

            root.left?.left?.left?.left = TreeNode(1)
            root.left?.left?.left?.right = TreeNode(3)

            root.left?.right?.left = TreeNode(15)
            root.left?.right?.right = TreeNode(19)

            root.right?.left = TreeNode(25)
            root.right?.right = TreeNode(58)

            return root
        }

        public fun getExampleTree4(): TreeNode {
            /*                 20
             *              /      \
             *            13        44
             *           /  \      /   \
             *         4      17  25   58
             *        / \    / \
             *       2   8  15 19
             *      / \
 			 *     1   3
             */
            val root: TreeNode = TreeNode(44)
            root.left = TreeNode(25)
            root.right = TreeNode(58)

//            root.left?.left = TreeNode(4)
//            root.left?.right = TreeNode(17)
//
//            root.left?.left?.left = TreeNode(2)
//            root.left?.left?.right = TreeNode(8)
//
//            root.left?.left?.left?.left = TreeNode(1)
//            root.left?.left?.left?.right = TreeNode(3)
//
//            root.left?.right?.left = TreeNode(15)
//            root.left?.right?.right = TreeNode(19)
//
//            root.right?.left = TreeNode(25)
//            root.right?.right = TreeNode(58)

            return root
        }

        public fun getExampleTree2(): TreeNode {
            /*                 15
             *            /        \
             *           6          42
             *         /  \        /   \
             *      4     9       33     55
             *     / \   / \     /  \    / \
             *    3   5 7   11  24  38  51  70
             */
            val root: TreeNode = TreeNode(15)
            root.left = TreeNode(6)
            root.right = TreeNode(42)

            root.left?.left = TreeNode(4)
            root.left?.right = TreeNode(9)

            root.right?.left = TreeNode(33)
            root.right?.right = TreeNode(55)

            root.left?.left?.left = TreeNode(3)
            root.left?.left?.right = TreeNode(5)
            root.left?.right?.left = TreeNode(7)
            root.left?.right?.right = TreeNode(11)

            root.right?.left?.left = TreeNode(24)
            root.right?.left?.right = TreeNode(38)
            root.right?.right?.left = TreeNode(51)
            root.right?.right?.right = TreeNode(70)

            return root
        }

        public fun getExampleTree3(): TreeNodeWithHd {
        /*                15
         *              /          \
         *            6             42
         *          /   \          /   \
         *        34      9       33     55
         *              / \     /  \    / \
         *            7   11  24  38  51  70
         *           /
         *        18
         *       /
         *     13
         *    /
         *   4
         *
         */
            val root: TreeNodeWithHd = TreeNodeWithHd(15)
            root.left = TreeNodeWithHd(6)
            root.right = TreeNodeWithHd(42)

            root.left?.left = TreeNodeWithHd(34)

            root.left?.right = TreeNodeWithHd(9)

            root.right?.left = TreeNodeWithHd(33)
            root.right?.right = TreeNodeWithHd(55)

            root.left?.right?.left = TreeNodeWithHd(7)
            root.left?.right?.right = TreeNodeWithHd(11)

            root.right?.left?.left = TreeNodeWithHd(24)
            root.right?.left?.right = TreeNodeWithHd(38)
            root.right?.right?.left = TreeNodeWithHd(51)
            root.right?.right?.right = TreeNodeWithHd(70)

            root.left?.right?.left?.left = TreeNodeWithHd(18)
            root.left?.right?.left?.left?.left = TreeNodeWithHd(13)
            root.left?.right?.left?.left?.left?.left = TreeNodeWithHd(4)

            return root
        }

        public fun getExampleTree5(): TreeNode {
/*
           6
         /   \
        3     5
      /   \     \
     2     5     4
         /  \
        7    4
*/
            val root: TreeNode = TreeNode(6)
            root.left = TreeNode(3)
            root.right = TreeNode(5)

            root.left?.left = TreeNode(2)
            root.left?.right = TreeNode(5)

            root.left?.right?.left = TreeNode(7)
            root.left?.right?.right = TreeNode(4)

            root.right?.right = TreeNode(4)

            return root
        }

        public fun getExampleTree6(): TreeNode {
/*

                 1
               /   \
              2     3
            /  \  /  \
           4   5  6   7

*/
            val root: TreeNode = TreeNode(1)
            root.left = TreeNode(2)
            root.right = TreeNode(3)

            root.left?.left = TreeNode(4)
            root.left?.right = TreeNode(5)

            root.right?.left = TreeNode(6)
            root.right?.right = TreeNode(7)

            return root
        }
    }
}