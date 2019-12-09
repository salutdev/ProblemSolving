package trees.model

class NaryTree {
    companion object {

        fun getExampleTee() : NaryTreeNode {

            /*                 15
             *            /    |  \     \
             *         6      14  22     42
             *      /  |  \    |   |  \     \
             *    18   7   45  64  95  13   19
             *             |             |
             *             40            35
             *
             *
             *
             */

            val root = NaryTreeNode(15)

            root.children = mutableListOf<NaryTreeNode>()
            val node6 = NaryTreeNode(6)
            val node14 = NaryTreeNode(14)
            val node22 = NaryTreeNode(22)
            val node42 = NaryTreeNode(42)
            root.children!!.add(node6)
            root.children!!.add(node14)
            root.children!!.add(node22)
            root.children!!.add(node42)

            node6.children = mutableListOf<NaryTreeNode>()
            val node18 = NaryTreeNode(18)
            val node7 = NaryTreeNode(7)
            val node45 = NaryTreeNode(45)
            node6.children!!.add(node18)
            node6.children!!.add(node7)
            node6.children!!.add(node45)

            node45.children = mutableListOf<NaryTreeNode>()
            val node40 = NaryTreeNode(40)
            node45.children!!.add(node40)


            node14.children = mutableListOf<NaryTreeNode>()
            val node64 = NaryTreeNode(64)
            node14.children!!.add(node64)

            node22.children = mutableListOf<NaryTreeNode>()
            val node95 = NaryTreeNode(95)
            val node13 = NaryTreeNode(13)
            node22.children!!.add(node95)
            node22.children!!.add(node13)

            node13.children = mutableListOf<NaryTreeNode>()
            val node35 = NaryTreeNode(35)
            node13.children!!.add(node35)

            node42.children = mutableListOf<NaryTreeNode>()
            val node19 = NaryTreeNode(19)
            node42.children!!.add(node19)

            return root
        }
    }
}