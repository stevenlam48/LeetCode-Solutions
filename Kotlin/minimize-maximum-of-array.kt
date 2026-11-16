package minimizemaximumofarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimizeArrayValue(nums: IntArray): Int {
        fun ceilDivide(a: Long, b: Int): Int {
            return ((a + b - 1) / b).toInt()
        }

        var result = 0
        var curr = 0L
        for (i in nums.indices) {
            curr += nums[i]
            result = maxOf(result, ceilDivide(curr, i + 1))
        }
        return result
    }
}
