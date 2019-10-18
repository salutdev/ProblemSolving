package combinatorics

import java.util.HashMap

class Permutations {
	
	fun printAllPermutations() {
		val str = "abc"

		// Boxing overhead
		val ar = str.toCharArray().toTypedArray()
		val n = str.length
		permute(ar, 0, n - 1)
	}

	private fun permute(ar: Array<Char>, startIndex: Int, endIndex: Int) {
		if (startIndex == endIndex) {
			ar.forEach { print("${it}") }
			println()
		}

		for (i in startIndex..endIndex) {
			if (startIndex == i || ar[startIndex] != ar[i]) {
				swap(ar, startIndex, i)
				permute(ar, startIndex + 1, endIndex)
				swap(ar, startIndex, i)
			}
		}
	}


	private fun swap(ar: Array<Char>, i: Int, j: Int) {
		if (i != j) {
			val temp = ar[i]
			ar[i] = ar[j]
			ar[j] = temp
		}
	}
	
	private fun getPermutations(s: String): MutableList<String> {
		
		if (s.length == 0) {
			return mutableListOf<String>("")
		}
		
		val firstLetter: Char = s[0]
		val remainder: String = s.substring(1)
		
		val perms = getPermutations(remainder)
		val list = mutableListOf<String>()
		
		for (item in perms) {
			for (i in 0..item.length) {
				list.add(insertAtPosition(firstLetter, item, i))
			}
		}
		return list
	}
	
	private fun insertAtPosition(firstLetter: Char, item: String, i: Int): String {
		val start = item.take(i)
		val end = item.takeLast(item.length - i)
		return start + firstLetter + end
	}
	
	fun printAllPermutations2() {
		println(getPermutations2(""))
	}
	
	private fun getPermutations2(s: String): MutableList<String> {
		
		val len = s.length
		
		if (len == 0) {
			return mutableListOf("")
		}
		
		val newPerms = mutableListOf<String>()
		
		for (i in 0..len-1) {
			
			val start = s.take(i)
			val end = s.takeLast(len - i - 1)
			val perms = getPermutations2(start + end)
			for (perm in perms) {
				newPerms.add(s[i] + perm)
			}
		}
		return newPerms
	}
	
	fun printAllPermutations3() {
		
		var list = mutableListOf<String>()
		getPermutations3("", "aac", list)
		println(list)
	}
	
	private fun getPermutations3(prefix: String, remainder: String, list: MutableList<String>) {
		if (remainder.length == 0) {
			list.add(prefix)
		}
		
		val len = remainder.length
		
		for (i in 0..len-1) {
			val start = remainder.take(i)
			val c = remainder[i]
			val end = remainder.takeLast(len - i - 1)
			getPermutations3(prefix + c, start + end, list)
		}
	}
	
	fun printAllPermutationsWithDups4() {
		val s = "ababcadc"
		//val s = "aaf"
		val hashMap = buildHashMap(s)
		val result = mutableListOf<String>()
		getPermutationsWithDups4("", s.length, result, hashMap)
		println(result)
		println(result.count())
	}
	
	private fun getPermutationsWithDups4(prefix: String, remainder: Int, result: MutableList<String>, map: HashMap<Char, Int>) {
		
		if (remainder == 0) {
			result.add(prefix)
			return
		}
		
		for (key in map.keys) {
			val count: Int = map[key]!!
			if (count > 0) {
				map.set(key, count - 1)
				getPermutationsWithDups4(prefix + key,  remainder - 1, result, map)
				map.set(key, count)
			}
		}
	}
	
	private fun buildHashMap(s: String): HashMap<Char, Int> {
		val hashMap = hashMapOf<Char, Int>()
		
		for (c in s) {
			if (hashMap.containsKey(c)) {
				hashMap.set(c, hashMap.get(c)!! + 1)
			} else {
				hashMap.set(c, 1)
			}
		}
		
		return hashMap
	}
	
	
	
}