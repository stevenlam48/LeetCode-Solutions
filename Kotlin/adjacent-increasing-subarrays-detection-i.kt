package adjacentincreasingsubarraysdetectioni

// Time:  O(n)
// Space: O(1)

class Solution {
    fun hasIncreasingSubarrays(nums: IntArray, k: Int): Boolean {
        var result = 0
        var curr = 1
        var prev = 0
        for (i in 0 until nums.size - 1) {
            if (nums[i] < nums[i + 1]) {
                ++curr
            } else {
                prev = curr
                curr = 1
            }
            result = maxOf(result, curr / 2, minOf(prev, curr))
        }
        return result >= k
    }
}
