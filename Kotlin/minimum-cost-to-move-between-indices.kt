package minimumcosttomovebetweenindices
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minCost(nums: IntArray, queries: Array<IntArray>): IntArray {
        val prefix = IntArray(nums.size)
        for (i in 0 until prefix.size - 1) {
            prefix[i + 1] = prefix[i] + (if (i == 0 || nums[i + 1] - nums[i] < nums[i] - nums[i - 1]) 1 else nums[i + 1] - nums[i])
        }
        val suffix = IntArray(nums.size)
        for (i in prefix.lastIndex downTo 1) {
            suffix[i - 1] = suffix[i] + (if (i + 1 == nums.size || nums[i] - nums[i - 1] <= nums[i + 1] - nums[i]) 1 else nums[i] - nums[i - 1])
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val left = queries[i][0]
            val right = queries[i][1]
            result[i] = if (left < right) prefix[right] - prefix[left] else suffix[right] - suffix[left]
        }
        return result
    }
}
