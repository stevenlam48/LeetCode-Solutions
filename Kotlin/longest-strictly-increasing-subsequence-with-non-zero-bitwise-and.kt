package longeststrictlyincreasingsubsequencewithnonzerobitwiseand
// Time:  O(logr * nlogn)
// Space: O(n)

class Solution {
    fun longestSubsequence(nums: IntArray): Int {
        fun lis(base: Int): Int {
            val result = mutableListOf<Int>()
            for (x in nums) {
                if (x and base == 0) {
                    continue
                }
                if (result.isEmpty() || result.last() < x) {
                    result.add(x)
                } else {
                    val index = result.binarySearch(x)
                    result[if (index >= 0) index else -index - 1] = x
                }
            }
            return result.size
        }

        val width = 32 - nums.max().countLeadingZeroBits()
        var result = 0
        for (bit in 0 until width) {
            result = maxOf(result, lis(1 shl bit))
        }
        return result
    }
}
