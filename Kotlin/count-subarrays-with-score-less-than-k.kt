package countsubarrayswithscorelessthank
// Time:  O(n)
// Space: O(1)

class Solution {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        var result = 0L
        var total = 0L
        var left = 0
        for (right in nums.indices) {
            total += nums[right]
            while (total * (right - left + 1) >= k) {
                total -= nums[left]
                ++left
            }
            result += right - left + 1
        }
        return result
    }
}
