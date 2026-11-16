package countdominantindices

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun dominantIndices(nums: IntArray): Int {
        var result = 0
        var total = 0L
        val n = nums.size
        for (i in 0 until n) {
            if (i.toLong() * nums[n - 1 - i] > total) {
                ++result
            }
            total += nums[n - 1 - i]
        }
        return result
    }
}
