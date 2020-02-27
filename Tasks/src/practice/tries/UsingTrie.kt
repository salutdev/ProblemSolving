package practice.tries
import practice.tries.model.Trie

class UsingTrie {
    fun calc() {
        val trie = Trie()
        trie.insert("abc")
        trie.insert("amln")
        trie.insert("abcd")

        val result = trie.getWordsWithPrefix("ab")
        result.forEach { r -> println(r) }
    }
}