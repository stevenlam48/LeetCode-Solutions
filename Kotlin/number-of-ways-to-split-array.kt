package numberofwaystosplitarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun waysToSplitArray(nums: IntArray): Int {
        val total = nums.sumOf { it.toLong() }
        var curr = 0L
        var result = 0
        for (i in 0 until nums.lastIndex) {
            curr += nums[i]
            if (curr >= total - curr) {
                ++result
            }
        }
        return result
    }
}
