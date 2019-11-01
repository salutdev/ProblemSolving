package searchAndSort

import kotlin.math.min

class MinHeap {

    fun calc() {
        val heapArray = arrayOf(12, 11, 13, 5, 6, 7)
        val n = heapArray.size
        buildMinHeap(heapArray, n)
        heapArray.forEach { print("$it, ") }

        //sort(heapArray, n)
        decreaseKey(heapArray, 3, n, 9)
        println()
        heapArray.forEach { print("$it, ") }
    }

    // Get index of left child of node at index i
    private fun left(i: Int) = 2 * i + 1
    // Get index of right child of node at index i
    private fun right(i: Int) = 2 * i + 2
    private fun parent(i: Int) = (i - 1) / 2

    private fun sort(heapArray: Array<Int>, n: Int) {
        for (i in n-1 downTo 0) {
            extractMin(heapArray, i)
        }
    }

    private fun decreaseKey(heapArray: Array<Int>, i: Int, n: Int, d: Int) {
        heapArray[i] -= d
        swimUp(heapArray, i, n)
    }

    private fun swimUp(heapArray: Array<Int>, i: Int, n: Int) {
        val parentIndex = parent(i)
        if (heapArray[i] < heapArray[parentIndex]) {
            swap(heapArray, parentIndex, i)
            swimUp(heapArray, parentIndex, n)
        }
    }

    private fun extractMin(heapArray: Array<Int>, endIndex: Int): Int {
        val min = heapArray[0]
        swap(heapArray, 0, endIndex)
        minHeapify(heapArray, 0, endIndex)
        return min
    }

    private fun buildMinHeap(heapArray: Array<Int>, n: Int) {
        for (i in n/2 - 1 downTo 0 ) {
            minHeapify(heapArray, i, n)
        }
    }

    private fun minHeapify(heapArray: Array<Int>, i: Int, n: Int) {
        var smallestIndex = getSmallestIndex(i, n, heapArray)
        if (smallestIndex != i) {
            swap(heapArray, i, smallestIndex)
            minHeapify(heapArray, smallestIndex, n)
        }
    }

    private fun getSmallestIndex(i: Int, n: Int, heapArray: Array<Int>): Int {
        var smallestIndex = i
        var left = left(i)
        var right = right(i)

        // If left child is smaller than root
        if (left < n && heapArray[left] < heapArray[smallestIndex]) {
            smallestIndex = left
        }

        // If left child is smaller than root
        if (right < n && heapArray[right] < heapArray[smallestIndex]) {
            smallestIndex = right
        }
        return smallestIndex
    }

    private fun swap(heapArray: Array<Int>, i: Int, smallestIndex: Int) {
        val temp = heapArray[i]
        heapArray[i] = heapArray[smallestIndex]
        heapArray[smallestIndex] = temp
    }
}