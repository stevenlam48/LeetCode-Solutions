package subarrayproductlessthank

// Time:  O(n)
// Space: O(1)

// Sliding window solution.
class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k <= 1) {
            return 0
        }
        var result = 0
        var start = 0
        var prod = 1
        for (i in nums.indices) {
            prod *= nums[i]
            while (prod >= k) {
                prod /= nums[start]
                ++start
            }
            result += i - start + 1
        }
        return result
    }
}
