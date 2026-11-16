package waystosplitarrayintothreesubarrays

// Time:  O(n)
// Space: O(n)

class Solution {
    fun waysToSplit(nums: IntArray): Int {
        val MOD = 1_000_000_007

        val prefix = LongArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }

        var result = 0
        var left = 0
        var right = 0
        for (i in nums.indices) {
            left = maxOf(left, i + 1)
            while (left + 1 < nums.size && prefix[i + 1] > prefix[left + 1] - prefix[i + 1]) {
                ++left
            }
            right = maxOf(right, left)
            while (right + 1 < nums.size && prefix[right + 1] - prefix[i + 1] <= prefix[nums.size] - prefix[right + 1]) {
                ++right
            }
            result = ((result.toLong() + (right - left)) % MOD).toInt()
        }
        return result
    }
}
