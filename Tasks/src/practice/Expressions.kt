package practice

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

// Given an array of numbers find all the numbers that can be generated from it using +-/() any where between the numbers.
// Array can have positive, negative, and duplicate.
class Expressions {

    enum class NextToken { Number, Operation, OpeningParen, ClosingParen }

    fun calcExpression() {

        val arr = arrayOf(2, 4, 8) //, 15, 3, 7)
        val opsArr = arrayOf("+", "-", "*", "/")

        //generateExpressions(arr, opsArr, 0, arr.size,  resultList, 0, NextToken.Digit)
        generateExpressions(arr, opsArr, 0, arr.size,  ArrayList<String>(), 0, NextToken.OpeningParen)

        hashMap.forEach { (value, count) ->
            println("$value  -  $count")
        }
        println("Count - ${hashMap.count()}")

        //val exprArr = arrayOf("-2", "-", "4", "*", "8", "/", "2", "+", "5", "*", "2", "+", "20", "*", "5")
        //val exprArr = arrayOf("8", "/", "(", "(", "-2", "+", "4", ")", "+", "(", "2", "+", "2", ")", ")") // "/", "2", "+", "20", "*", "5")
//        val exprArr = arrayOf("(", "1", "-", "3", "*", "(", "2", "+", "(", "7", "+", "4", ")", ")", ")", "/", "2") // "/", "2", "+", "20", "*", "5")
//        val result = calcExpressionWithParenthesis(exprArr)
//        println(result)
    }

    private val hashMap = HashMap<Double, Int>()

    private fun generateExpressions(arr: Array<Int>, opsArr: Array<String>, i: Int, n: Int, resultList: ArrayList<String>, openParenCount: Int, nextToken: NextToken) {
        if (i >= n && openParenCount <= 0) {
            val result = calcExpressionWithParenthesis(resultList.toTypedArray())

            resultList.forEach { e -> print("$e ") }
            println(" = $result")

            if (hashMap.containsKey(result)) {
                hashMap[result] = hashMap[result]!! + 1
            } else {
                hashMap[result] = 1
            }

            return
        }

        when (nextToken) {
            NextToken.Number -> {
                if (i < n) {
                    resultList.add(arr[i].toString())
                    generateExpressions(arr, opsArr, i + 1, n, resultList, openParenCount, NextToken.ClosingParen)
                    resultList.removeAt(resultList.lastIndex)
                }
            }

            NextToken.Operation -> {
                if (i != 0 && i < n) {
                    for (op in opsArr) {
                        resultList.add(op)
                        generateExpressions(arr, opsArr, i, n, resultList, openParenCount, NextToken.OpeningParen)
                        resultList.removeAt(resultList.lastIndex)
                    }
                }
            }

            NextToken.OpeningParen -> {
                if (i < n) {
                    generateExpressions(arr, opsArr, i, n, resultList, openParenCount, NextToken.Number)
                    if (i < n - 1 && openParenCount < n - 1) {
                        resultList.add("(")
                        generateExpressions(arr, opsArr, i, n, resultList, openParenCount + 1, NextToken.OpeningParen)
                        resultList.removeAt(resultList.lastIndex)
                    }
                }
            }

            NextToken.ClosingParen -> {
                if (i < n) {
                    generateExpressions(arr, opsArr, i, n, resultList, openParenCount, NextToken.Operation)
                }
                if (openParenCount > 0 && i > 1) {
                    resultList.add(")")
                    generateExpressions(arr, opsArr, i, n, resultList, openParenCount - 1, NextToken.ClosingParen)
                    resultList.removeAt(resultList.lastIndex)
                }
            }
        }
    }

    // Calculate expression with + - * / ( ) symbols
    private fun calcExpressionWithParenthesis(arr: Array<String>): Double {
        val stack = Stack<String>()

        for (e in arr) {
            if (e != ")") {
                stack.push(e)
            } else {
                val index = stack.lastIndexOf("(")
                val simpleExpressionArr = stack.slice(index + 1 until stack.size)
                stack.setSize(index)

                val simpleExpressionValue = calcSimpleExpression(simpleExpressionArr.toTypedArray())
                stack.push(simpleExpressionValue.toString())
            }
        }

        // At this point there are no parentheses
        return calcSimpleExpression(stack.toTypedArray())
    }

    // Calculate expression with + - * / but without ()
    private fun calcSimpleExpression(arr: Array<String>): Double {
        val n = arr.size
        var sum = 0.0
        var product = 1.0
        var isPrevOperationProduct = false

        if (arr == null || n == 0) return 0.0
        if (arr.size == 1) return arr[0].toDouble()

        for (i in 1 until n step 2) {
            when (arr[i]) {
                "+", "-" -> {
                    if (isPrevOperationProduct) {
                        sum += product * arr[i - 1].toDouble()
                        isPrevOperationProduct = false
                        product = 1.0
                    } else {
                        sum += arr[i - 1].toDouble()
                    }

                    if (arr[i] == "-") {
                        arr[i + 1] = (arr[i + 1].toDouble() * (-1.0)).toString()
                    }
                }

                "*" -> {
                    product *= arr[i - 1].toDouble()
                    isPrevOperationProduct = true
                }

                "/" -> {
                    product *= arr[i - 1].toDouble()
                    arr[i + 1] = (1.0 / arr[i + 1].toDouble()).toString()
                    isPrevOperationProduct = true
                }
            }
        }

        if (isPrevOperationProduct) {
            sum += product * arr.last().toDouble()
        } else {
            sum += arr.last().toDouble()
        }

        return sum
    }
}