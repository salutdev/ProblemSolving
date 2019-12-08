package practice

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet


/*
Given an input string in the format String s = "abc{d,e}f{gh,ij}".
Expected output: [abcdfgh, abcdfij, abcefgh, abcefij]
This is exact output of echo abc{d,e}f{gh,ij} on a bash terminal. Braces can be nested.
*/

class BraceExpansion {

    fun calc() {
        // Output: abcdhi abcdhj abcehi abcehj abcfhi abcfhj abcghi abcghj
        //val str = "abc{d,{e,f},g}h{i,j}"
        //val str = "abc{d,{e,f}}"
        //val str = "a{b,c{d,e}}"
        //val str = "a{b,c{d,e},{f,g}}"
        //val str = "a{b,c{d,e},{f,g}h{j,m{k,l}n}}"
        val str = "{a,b,c{x,y}}b{p,q}"

        val expressions = HashMap<Int, String>()

        val processedTemplate = processTemplate(str, expressions)
        generateStrings("", processedTemplate, expressions)
    }

    private fun generateStrings(prefix: String, suffix: String, expressions: HashMap<Int, String>) {

        var newPrefix = prefix
        var isBracketOpen = false
        var exprIdStr = ""
        var isResult = true;

        for (i in suffix.indices) {
            val c = suffix[i]
            if (c == '[') {
                isBracketOpen  = true
            } else if (c == ']') {
                isBracketOpen = false
                val exprId = exprIdStr.toInt()
                exprIdStr = ""
                val curExprStr = expressions[exprId]!!
                val exprArr = curExprStr.split(",")

                for (ex in exprArr) {
                    generateStrings(newPrefix, ex + suffix.substring(i + 1), expressions)
                }

                isResult = false
                break;
            } else {
                if (!isBracketOpen) {
                    newPrefix += c
                } else {
                    exprIdStr += c
                }
            }
        }

        if (isResult) print("$newPrefix ")
    }

    private fun processTemplate(str: String, expressions: HashMap<Int, String>): String {

        val stack = Stack<String>()
        val tempStack = Stack<String>()

        var exprIndex = 0

        for (i in str.indices) {
            var strChar = str[i].toString()
            if (strChar == "}") {
                var symbol = ""
                while(stack.isNotEmpty() && symbol != "{") {
                    symbol = stack.pop()
                    if (symbol != "{") {
                        tempStack.push(symbol)
                    }
                }

                var expr = ""
                while (tempStack.isNotEmpty()) {
                    expr += tempStack.pop()
                }

                expressions[exprIndex] = expr

                stack.push("[$exprIndex]")
                exprIndex++

            } else {
                stack.push(strChar)
            }
        }

        var result = ""
        stack.toArray().forEach { result += it }

        return result
    }


    fun calcWithHashSet() {
        // Output: abcdhi abcdhj abcehi abcehj abcfhi abcfhj abcghi abcghj
        val str = "abc{d,{e,f},g}h{i,j}"
        //val str = "abc{d,{e,f}}"
        val resultHash = HashSet<String>()
        processTemplateWithHashSet(str, resultHash)
        resultHash.forEach { print("$it ")}
    }

    private fun processTemplateWithHashSet(str: String, resultHash: HashSet<String>) {

        val stack = Stack<Char>()
        val tempStack = Stack<Char>()
        var isFinalString = true

        for (i in str.indices) {
            if (str[i] == '}') {
                var symbol: Char = ' '
                while(stack.isNotEmpty() && symbol != '{') {
                    symbol = stack.pop()
                    if (symbol != '{') {
                        tempStack.push(symbol)
                    }
                }

                var prefixStr = ""
                stack.toArray().forEach { prefixStr += it }
                val suffixStr =  str.substring(i+1)
                var midStr = ""
                while (tempStack.isNotEmpty()) {
                    midStr += tempStack.pop()
                }

                val midArr = midStr.split(",")
                midArr.forEach {
                    val newStr = prefixStr + it + suffixStr
                    processTemplateWithHashSet(newStr, resultHash)
                }

                isFinalString = false
                break

            } else {
                stack.push(str[i])
            }
        }

        if (isFinalString) resultHash.add(str)
    }
}