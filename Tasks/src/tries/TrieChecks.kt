package tries

class TrieChecks {

    fun check() {
        val trie = Trie()
        trie.insert("abc")
        trie.insert("a")
        trie.insert("abcd")

        var result = false
        //result = trie.delete2("a")
        //result = trie.delete2("a")
        //result = trie.delete2("abc")
        result = trie.delete("abcd")
        result = trie.delete("abc")
        println(result)
    }
}