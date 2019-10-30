package combinatorics

import java.util.*

class Subsets {

	fun printAllSubsetsWithDups() {
		val set = arrayOf("a", "a", "b", "c")
		val result = Array<String>(set.size) { "" }

		val sortedMap = TreeMap<String, Int>()

		set.forEach { e ->
			if (sortedMap.containsKey(e)) {
				sortedMap[e] = sortedMap[e]!! + 1
			} else {
				sortedMap[e] = 1
			}
		}

		val keys: Array<String> = sortedMap.keys.toTypedArray()

		val n = sortedMap.size

		printAllSubsetsWithDupsRec(keys, sortedMap, result, 0, n, 0)
	}

	private fun printAllSubsetsWithDupsRec(keys: Array<String>, sortedMap: TreeMap<String, Int>, result: Array<String>, index: Int, n: Int, resultIndex: Int) {

		for (i in index until n) {
			val key = keys[i]
			if (sortedMap[key]!! > 0) {
				result[resultIndex] = key
				println() // prints initial empty set
				for (j in 0..resultIndex) {
					print("${result[j]}")
				}
				sortedMap[key] = sortedMap[key]!! - 1
				printAllSubsetsWithDupsRec(keys, sortedMap, result, i, n, resultIndex + 1)
				sortedMap[key] = sortedMap[key]!! + 1
			}
		}
	}


	fun printAllSubsets2() {
		
		val set = listOf(1, 2, 7)
		
		val result: MutableList<MutableList<Int>> = getSubsets(set, set.size - 1)
		for (list in result) {
			println(list)
		}
	}
	
	private fun getSubsets(set: List<Int>, index: Int): MutableList<MutableList<Int>> {
		
		if (index == -1) {
			return mutableListOf<MutableList<Int>>(mutableListOf())
		} else {
			var allSubsets = getSubsets(set, index - 1)
			val value = set[index]
			var moreSubsets = mutableListOf<MutableList<Int>>()
			for (subset in allSubsets) {
				var newSubset = mutableListOf<Int>()
				newSubset.addAll(subset)
				newSubset.add(value)
				moreSubsets.add(newSubset)
			}
			
			allSubsets.addAll(moreSubsets)
			return allSubsets
		}
	}
	
	
	fun printAllSubsets3() {
		
		val set: List<Int> = listOf(3, 6, 2)
		
		for (i in 0.. (1 shl set.size) - 1) {
			
			println(buildSubset(set, i))
		}
	}
	
	private fun buildSubset(set: List<Int>, i: Int): List<Int> {

		var list: MutableList<Int> = mutableListOf()
		var index = 0
		var n = i
		while (n > 0) {
			if (n and 1 == 1) {
				list.add(set[index])
			}
			index++
			n = n shr 1
		}
		return list.map {it}
	}
}
