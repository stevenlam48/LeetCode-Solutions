package waystosplitarrayintogoodsubarrays

// Time:  O(n)
// Space: O(1)

// combinatorics
class Solution {
    fun numberOfGoodSubarraySplits(nums: IntArray): Int {
        val MOD = 1_000_000_007
        var result = 1L
        var prev = -1
        for (i in nums.indices) {
            if (nums[i] != 1) {
                continue
            }
            if (prev != -1) {
                result = result * (i - prev) % MOD
            }
            prev = i
        }
        return if (prev != -1) result.toInt() else 0
    }
}
