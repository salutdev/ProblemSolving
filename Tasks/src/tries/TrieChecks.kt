package tries

import tries.model.Trie

class TrieChecks {

    fun check() {
        val trie = Trie()
        trie.insert("abc")
        trie.insert("a")
        trie.insert("abcd")
        trie.insert("adb")
        trie.insert("day")

        var result = false
        result = trie.delete("a")
        result = trie.delete("abc")
        result = trie.delete("abcd")
        result = trie.delete("adb")
        result = trie.delete("day")

        trie.displayContent()
        println(result)
    }
}