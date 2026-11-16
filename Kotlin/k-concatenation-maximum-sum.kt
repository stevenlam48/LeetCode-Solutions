package kconcatenationmaximumsum
// Time:  O(n)
// Space: O(1)

class Solution {
    fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
        val mod = 1_000_000_007L
        if (k == 1) {
            return (maxOf(maxSubKArray(arr, 1), 0) % mod).toInt()
        }
        return ((maxOf(maxSubKArray(arr, 2), 0) +
            (k - 2L) * maxOf(arr.sumOf { it.toLong() }, 0L)) % mod).toInt()
    }

    private fun maxSubKArray(nums: IntArray, k: Int): Int {
        var result = Int.MIN_VALUE
        var curr = Int.MIN_VALUE
        for (i in 0 until k) {
            for (x in nums) {
                curr = if (curr == Int.MIN_VALUE) x else maxOf(curr + x, x)
                result = maxOf(result, curr)
            }
        }
        return result
    }
}
