package minimumaveragedifference

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumAverageDifference(nums: IntArray): Int {
        val total = nums.sumOf { it.toLong() }
        var minimum = Long.MAX_VALUE
        var index = -1
        var prefix = 0L
        for (i in nums.indices) {
            prefix += nums[i]
            val first = prefix / (i + 1)
            val second = if (i + 1 < nums.size) (total - prefix) / (nums.size - (i + 1)) else 0
            val difference = kotlin.math.abs(first - second)
            if (difference < minimum) {
                minimum = difference
                index = i
            }
        }
        return index
    }
}
