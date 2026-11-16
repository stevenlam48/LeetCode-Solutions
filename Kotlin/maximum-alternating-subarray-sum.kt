package maximumalternatingsubarraysum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumAlternatingSubarraySum(nums: IntArray): Long {
        return maxOf(kadane(nums, 0), kadane(nums, 1))
    }

    private fun kadane(nums: IntArray, start: Int): Long {
        var result = Long.MIN_VALUE
        var curr = 0L
        var odd = 0
        for (i in start until nums.size) {
            curr = if (odd == 0) curr + nums[i] else maxOf(curr - nums[i], 0L)
            result = maxOf(result, curr)
            odd = odd xor 1
        }
        return result
    }
}
