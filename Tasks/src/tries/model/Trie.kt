package tries.model

class Trie {

    class TrieNode {
        var children = HashMap<Char, TrieNode>()
        var endOfWord = false
    }

    private var root = TrieNode()
    private  var shouldRemove = false

    fun displayContent() {

        displayContentRec(root, "")
    }

    fun displayContentRec(current: TrieNode, curStr: String) {

        if (current == null) return
        if (current.endOfWord) println(curStr)
        if (current.children.size == 0) return


        for (c in current.children.keys) {
            val node = current.children[c]
            displayContentRec(current.children[c]!!, curStr + c)
        }
    }

    fun insert(str: String) {
        var current: TrieNode? = root

        for (i in str.indices) {
            if (current!!.children.containsKey(str[i])) {
                current = current.children[str[i]]
            } else {
                val newNode = TrieNode()
                current.children.put(str[i], newNode)
                current = newNode
            }
        }
        current?.endOfWord = true;
    }

    fun search(str: String): Boolean {
        var current: TrieNode? = root

        for (c in str) {
            if (!current!!.children.containsKey(c)) {
                return false
            }
            current = current!!.children[c]
        }
        return current!!.endOfWord
    }

    fun delete(str: String): Boolean {
        return deleteRec(root, str, 0, str.length)
    }

    private fun deleteRec(current: TrieNode?, str: String, index: Int, n: Int): Boolean {

        if (index == n) {
            return if (current!!.endOfWord) {
                shouldRemove = current.children.size == 0
                current!!.endOfWord = false
                true
            } else {
                false
            }
        }

        return if (current!!.children.containsKey(str[index])) {
            val result = deleteRec(current!!.children[str[index]], str, index + 1, n)
            if (result && shouldRemove) {
                current.children.remove(str[index])
                shouldRemove = current.children.size == 0 && !current.endOfWord
            }
            result
        } else {
            false
        }
    }

    fun deleteIter(str: String): Boolean {
        var current: TrieNode? = root

        for (c in str) {
            if (!current!!.children.containsKey(c)) {
                return false
            }
            current = current!!.children[c]
        }

        if (current!!.endOfWord) {
            current!!.endOfWord = false
            return true
        } else {
            return false
        }
    }
}