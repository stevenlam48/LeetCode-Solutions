package maximumvalidpairsum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxValidPairSum(nums: IntArray, k: Int): Int {
        var result = 0
        var prefix = 0
        for (i in 0 until nums.size - k) {
            prefix = maxOf(prefix, nums[i])
            result = maxOf(result, prefix + nums[i + k])
        }
        return result
    }
}
