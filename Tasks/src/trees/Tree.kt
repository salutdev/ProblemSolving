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

        public fun getExampleTree3(): TreeNode {
        /*                15
         *            /        \
         *           6          42
         *         /  \        /   \
         *      4     9       33     55
         *     / \   / \     /  \    / \
         *    3   5 7   11  24  38  51  70
         */
            val root: TreeNode = TreeNode(-15)
            root.left = TreeNode(-6)
            root.right = TreeNode(-42)

//        root.left?.left = TreeNode(4)
//        root.left?.right = TreeNode(9)
//
//        root.right?.left = TreeNode(33)
//        root.right?.right = TreeNode(55)
//
//        root.left?.left?.left = TreeNode(3)
//        root.left?.left?.right = TreeNode(5)
//        root.left?.right?.left = TreeNode(7)
//        root.left?.right?.right = TreeNode(11)
//
//        root.right?.left?.left = TreeNode(24)
//        root.right?.left?.right = TreeNode(38)
//        root.right?.right?.left = TreeNode(51)
//        root.right?.right?.right = TreeNode(70)

            return root
        }
    }
}