package distinctnumbersineachsubarray

// Time:  O(n)
// Space: O(k)

class Solution {
    fun distinctNumbers(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val count = HashMap<Int, Int>()
        for (i in nums.indices) {
            count.merge(nums[i], 1, Int::plus)
            if (i >= k) {
                val prev = nums[i - k]
                val c = count[prev]!! - 1
                if (c == 0) {
                    count.remove(prev)
                } else {
                    count[prev] = c
                }
            }
            if (i + 1 >= k) {
                result.add(count.size)
            }
        }
        return result.toIntArray()
    }
}
