package relativeranks
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findRelativeRanks(nums: IntArray): Array<String> {
        val indices = IntArray(nums.size) { it }
        val sortedIndices = indices.sortedByDescending { nums[it] }
        val ranks = arrayOf("Gold Medal", "Silver Medal", "Bronze Medal")
        val result = Array(nums.size) { "" }
        for (i in nums.indices) {
            result[sortedIndices[i]] = if (i > 2) (i + 1).toString() else ranks[i]
        }
        return result
    }
}
