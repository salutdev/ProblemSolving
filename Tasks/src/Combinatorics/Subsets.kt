package Combinatorics

class Subsets {
	
	fun printAllSubsets() {
		
		val set = listOf(1, 5, 7)
		
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
	
	
	fun printAllSubsets2() {
		
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
