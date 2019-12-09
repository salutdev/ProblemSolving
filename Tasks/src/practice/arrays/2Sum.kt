package practice.arrays

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

class `2Sum` {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for (i in 0 until nums.count()) {

            val temp = target - nums[i]
            if (map.containsKey(temp)) {
                return intArrayOf(map[temp]!!, i)
            } else {
                map[nums[i]] = i
            }
        }

        return intArrayOf(-1, -1)
    }
}