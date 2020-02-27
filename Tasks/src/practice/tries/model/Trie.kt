package practice.tries.model

class Trie {

    class TrieNode {
        var value: Char? = null
        val children = HashMap<Char, TrieNode>()
        var endOfWord = false
    }

    private var root = TrieNode()

    fun insert(str: String) {
        var current = root

        str.forEach { c ->
            if (current.children.containsKey(c)) {
                current = current.children[c]!!
            } else {
                val node = TrieNode()
                node.value = c
                current.children[c] = node
                current = node
            }
        }

        current.endOfWord = true
    }

    fun getWordsWithPrefix(prefix: String): List<String> {

        val result = mutableListOf<String>()
        var current = root

        prefix.forEach { c ->
            if (current.children.containsKey(c)) {
                current = current.children[c]!!
            } else {
                return result
            }
        }

        if (current.endOfWord) {
            result.add(prefix)
        }

        getWordsWithPrefixRec(prefix, current, result)

        return result
    }

    private fun getWordsWithPrefixRec(prefix: String, current: TrieNode, result: MutableList<String>) {

        current.children.forEach {ch ->
            if (ch.value.endOfWord) {
                result.add(prefix + ch.key)
            }
            getWordsWithPrefixRec(prefix + ch.key, ch.value, result)
        }
    }
}