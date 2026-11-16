package maximizescoreafterpairdeletions
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxScore(nums: IntArray): Int {
        val total = nums.sum()
        if (nums.size % 2 != 0) {
            return total - nums.min()
        }
        var mn = Int.MAX_VALUE
        for (i in 0 until nums.size - 1) {
            mn = minOf(mn, nums[i] + nums[i + 1])
        }
        return total - mn
    }
}
