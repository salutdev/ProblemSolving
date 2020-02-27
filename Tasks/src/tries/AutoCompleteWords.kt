package tries

import java.util.*
import kotlin.collections.HashMap

/*
Having dictionary of words write method to return list of autocomplete words by entered words prefix.
Min length of prefix is 2 letters. Return max 3 words for each prefix sorted alphabetically.

Example:
    dictionalry: "cbgdk", "cbgdf", "cbgdm", "cbgdz", "cbgr", "cbg", "cbb"
    input prefix: "cbgd"

    Auto complete words result:

        cbb, cbg, cbgdf
        cbg, cbgdf, cbgdk
        cbgdf, cbgdk, cbgdm

    Explanation:
        first line is for prefix "cb" from input prefix
        second line for "cdg"
        third for "cbgd"
 */
class AutoCompleteWords {

    fun calc() {
        val listOfWords = listOf("cbgdk", "cbgdf", "cbgdm", "cbgdz", "cbgr", "cbg", "cbb")
        val inputWord = "cbgd"
        val result = getAutocompleteWords(inputWord, listOfWords)
        result.forEach { l -> println(l.joinToString()) }
    }

    fun getAutocompleteWords(inputWord: String, listOfWords: List<String>): List<List<String>> {
        if (inputWord == null || inputWord.length < 2) return listOf<List<String>>()
        val trie = Trie()
        listOfWords.forEach { w -> trie.insert(w) }
        val maxWords = 3
        val minPrefixLength = 2
        return trie.getWordsStartingWithPrefix(inputWord, minPrefixLength, maxWords)
    }


    class Trie {

        class TrieNode {
            var value: String = ""
            var children = HashMap<Char, TrieNode>()
            var endOfWord = false
        }

        private var root = TrieNode()

        fun insert(str: String) {
            var current: TrieNode? = root

            for (i in str.indices) {
                if (current!!.children.containsKey(str[i])) {
                    current = current.children[str[i]]
                } else {
                    val newNode = TrieNode()
                    newNode.value = str[i].toString()
                    current.children.put(str[i], newNode)
                    current = newNode
                }
            }
            current?.endOfWord = true;
        }

        fun getWordsStartingWithPrefix(prefix: String, minPrefixLength: Int, maxWords: Int): List<List<String>> {

            var node: TrieNode? = root
            val stack = Stack<TrieNode>()

            for (c in prefix) {
                if (node!!.children.containsKey(c)) {
                    stack.push(node)
                    node = node.children[c]
                } else {
                    return listOf<List<String>>()
                }
            }

            val result = mutableListOf<MutableList<String>>()
            var curPrefix = prefix

            while (stack.isNotEmpty() && curPrefix.length >= minPrefixLength && node != null && node?.value != "") {
                val singleResult = mutableListOf<String>()
                getWordsStartingWithPrefixRec(node, curPrefix, singleResult)

                var resultCount = result.count()
                if (resultCount != 0) {
                    val copyList = result[resultCount - 1].map { e -> e } as MutableList<String>
                    result.add(copyList)
                    result[resultCount].addAll(singleResult)
                    result[resultCount].sort()
                    result[resultCount - 1] = result[resultCount - 1].take(maxWords) as MutableList<String>
                } else {
                    singleResult.sort()
                    result.add(singleResult)
                }

                val char = node?.value?.single() as Char
                node = stack.pop()
                node.children.remove(char)
                curPrefix = curPrefix.dropLast(1)
            }

            result.reverse()
            result[0] = result[0].take(maxWords)  as MutableList<String>
            return result
        }

        private fun getWordsStartingWithPrefixRec(current: TrieNode?, prefix: String, result: MutableList<String>) {

            if (current == null) return
            if (current.endOfWord) result.add(prefix)
            if (current.children.size == 0) return

            for (c in current.children.keys) {
                getWordsStartingWithPrefixRec(current.children[c]!!, prefix + c, result)
            }
        }
    }
}