package countgoodsubarrays

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countGoodSubarrays(nums: IntArray): Long {
        fun isProperSubset(a: Int, b: Int): Boolean {
            return a != b && (a or b) == b
        }

        fun isSubset(a: Int, b: Int): Boolean {
            return (a or b) == b
        }

        val right = IntArray(nums.size) { nums.size }
        val stk = mutableListOf<Int>()
        for (i in nums.size - 1 downTo 0) {
            while (stk.isNotEmpty() && isSubset(nums[stk.last()], nums[i])) {
                stk.removeAt(stk.lastIndex)
            }
            right[i] = if (stk.isNotEmpty()) stk.last() else nums.size
            stk.add(i)
        }
        var result = 0L
        stk.clear()
        var left = -1L
        for (i in nums.indices) {
            while (stk.isNotEmpty() && isProperSubset(nums[stk.last()], nums[i])) {
                stk.removeAt(stk.lastIndex)
            }
            left = if (stk.isNotEmpty()) stk.last().toLong() else -1
            stk.add(i)
            result += (i - left) * (right[i] - i)
        }
        return result
    }
}
