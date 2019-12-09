package trees.model

class RangeTreeNode(var value: Int) {
    var rank: Int = 0
    var left: RangeTreeNode? = null
    var right: RangeTreeNode? = null
}