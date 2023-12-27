package languageConstructions

import graphs.model.DiGraphNode
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Collections {

    fun arrays() {

        val strs1 = listOf<Int>()
        val strs2 = listOf("string1", "string2", "string3")      // immutable array

        val result = mutableListOf<MutableList<Int>>()
        var row: MutableList<Int>? = null

        val strs3 = arrayListOf<Int>()
        val strs4 = arrayListOf<String>("str1", "str2")         // mutable array

        val ar1 = arrayOf(4, 2, 5, 7)
        val ar2 = Array<Int>(4) {0}

        val m = 2
        val n = 3

        val ar3 = Array(m) { IntArray(n) }
        val ar4 = Array(m) { IntArray(n) {0} }

      /*  Array<Int> is an Integer[] under the hood, while IntArray is an int[].

        This means that when Int is put in an Array<Int>, it will always be boxed
        (specifically, with an Integer.valueOf() call). In the case of IntArray, no boxing
        will occur, because it translates to a Java primitive array.


        Primitive arrays can be left uninitialized and they will have default 0 values at all
        indexes. This is why IntArray and the rest of the primitive arrays have constructors
        that only take a size parameter:
      */

        val arr = IntArray(10)
        println(arr.joinToString()) // 0, 0, 0, 0, 0, 0, 0, 0, 0, 0

        val arr2 = Array<Int>(10) { index -> 0 }  // full, verbose syntax
        val arr3 = Array(10) { 0 }                // concise version

/*
        Or create an Array<Int?> to avoid having to initialize every value, but then you'll
        be later forced to deal with possible null values every time you read from the array.
*/

        val arr4 = arrayOfNulls<Int>(10)

    }

    fun queue() {

        val queue = LinkedList<Int>()       // Queue
        while(queue.isNotEmpty()) {

            queue.addLast(3)
            val node = queue.removeFirst()
        }


        val queue2: Queue<Int> = ArrayDeque<Int>()
        val node: Int = queue2.remove()
        queue2.add(4)
    }


    fun priorityQueue() {
        val minPq = PriorityQueue<DiGraphNode> { a, b -> if (a.distanceFromSource > b.distanceFromSource) 1 else if (a == b) 0 else -1 }
        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
        minPq.add(null)

        while (minPq.isNotEmpty()) {
            val node = minPq.remove()
        }
    }
    fun maps() {

        val map1 = mapOf<String, String>()     // immutable map
        val map2 = mapOf("key1" to "value1", "key2" to "value2")     // immutable map
        var value = map2["key1"]
        value = map2.get("key1")


        val map4 = HashMap<String, String>()  // mutable map

        val map3 = hashMapOf("key1" to "value1", "key2" to "value2")     // mutable map
        map3.put("key3", "value3")
        map3["key3"] = "value3"
        map3.remove("key3")
        map3.clear()


        val map5 = mutableMapOf<String, Int?>()
        println(map5.getOrPut("x") { 2 }) // 2
        // subsequent calls to getOrPut do not evaluate the default value
        // since the first getOrPut has already stored value 2 in the map
        println(map5.getOrPut("x") { 3 }) // 2

        val newVal = map5.getOrElse("x") {0}?.plus(1)

        val map6 = mutableMapOf<String, Int>()
        val newVal2 = map6.getOrElse("x") {0} + 1

        map6.merge("you", 2, Int::plus)
        map6.computeIfPresent("you"){ _, v -> v + 2 }
        map6.putIfAbsent("key", 0)

        val map7 = mutableMapOf<Int, String>()
       // Sets value "first" and returns null
        val first = map7.putIfAbsent(1, "first")
        // value won't be set and value "first" is returned
        val second = map7.putIfAbsent(1, "second")


        val map8 = mutableMapOf<Int, String?>()
       // result of calculation is null, not added, returns null
        val first = map8.computeIfAbsent(1) { key ->
            null
        }
        // result of calculation is added, returns "1 second attempt"
        val second = map8.computeIfAbsent(1) { key ->
            "$key second attempt"
        }
        // value for the given key already exists, current value "1 second attempt" is returned
        val third = map8.computeIfAbsent(1) { key ->
            "$key third attempt"
        }


        // [first, second]
        val multiMap = mutableMapOf<Int, MutableSet<String>>()
        multiMap.computeIfAbsent(1) { mutableSetOf() }.add("first")
        multiMap.computeIfAbsent(1) { mutableSetOf() }.add("second")
    }

    private fun hashMapExample(s: String): java.util.HashMap<Char, Int> {
        val hashMap = hashMapOf<Char, Int>()

        for (c in s) {
            if (hashMap.containsKey(c)) {
                hashMap[c] = hashMap[c]!! + 1
            } else {
                hashMap[c] = 1
            }
        }

        // Or shorter notation for update
        hashMap[c] = hashMap.getOrDefault(c, 0) + 1

        return hashMap
    }

    fun hashSets() {
        val hashset1 = hashSetOf<String>("string1", "string2")
        val hashset2 = HashSet<String>()
    }

    fun treeMap() {
        val sortedMap = TreeMap<String, Int>()
        val set = arrayOf("a", "a", "b", "c")

        set.forEach { e ->
            if (sortedMap.containsKey(e)) {
                sortedMap[e] = sortedMap.get(e)!! + 1
            } else {
                sortedMap[e] = 1
            }
        }
    }
}
