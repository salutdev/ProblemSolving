class MyClass {
	
	companion object {
        @JvmStatic fun main(args: Array<String>) {
			
			val numbers: MutableList<Int> = mutableListOf(5, 10, 18)
			numbers.add(777)
			println(numbers)
			
			val readOnlyView: List<Int> = listOf(44, 66, 34)
			
			println(readOnlyView)
			
			val hashSet = hashSetOf<Int>(5, 4, 3, 2, 1)
			hashSet.add(222)
			println(hashSet)
			
			val hashMap: Map<String, Int> = hashMapOf("b" to 3, "a" to 4)
			println(hashMap)
		}
    }
}