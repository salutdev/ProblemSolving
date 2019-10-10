package trees

class TreeNodeWithHd(val value: Int) {
    var hd: Int = 0
    var left: TreeNodeWithHd? = null
    var right: TreeNodeWithHd? = null
}