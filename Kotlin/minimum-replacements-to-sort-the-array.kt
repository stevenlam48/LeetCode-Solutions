package minimumreplacementstosortthearray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumReplacement(nums: IntArray): Long {
        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        var result = 0L
        var curr = nums.last()
        for (i in nums.indices.reversed()) {
            val cnt = ceilDivide(nums[i], curr)
            result += cnt - 1
            curr = nums[i] / cnt
        }
        return result
    }
}
