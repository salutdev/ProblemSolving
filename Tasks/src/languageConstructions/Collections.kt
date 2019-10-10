package languageConstructions

import java.util.*
import kotlin.collections.HashMap

class Collections {

    fun arrays() {

        val strs1 = listOf<Int>()
        val strs2 = listOf("string1", "string2", "string3")      // immutable array

        val strs3 = arrayListOf<Int>()
        val strs4 = arrayListOf<String>("str1", "str2")         // mutable array

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
    }
}