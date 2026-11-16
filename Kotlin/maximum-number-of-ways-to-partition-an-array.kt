package maximumnumberofwaystopartitionanarray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun waysToPartition(nums: IntArray, k: Int): Int {
        val total = nums.sumOf { it.toLong() }
        val right = HashMap<Long, Int>()
        var prefix = 0L
        for (i in 0 until nums.size - 1) {
            prefix += nums[i]
            val diff = prefix - (total - prefix)
            right[diff] = (right[diff] ?: 0) + 1
        }
        var result = (right[0] ?: 0).toLong()
        val left = HashMap<Long, Int>()
        prefix = 0L
        for (x in nums) {
            val delta = (k - x).toLong()
            result = maxOf(result, (left[delta] ?: 0).toLong() + (right[-delta] ?: 0))
            prefix += x
            val diff = prefix - (total - prefix)
            right[diff] = (right[diff] ?: 0) - 1
            left[diff] = (left[diff] ?: 0) + 1
        }
        return result.toInt()
    }
}
