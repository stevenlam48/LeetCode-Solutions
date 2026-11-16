package countsubarrayswithloosebounds

// Time:  O(n)
// Space: O(1)

// two pointers
class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var result = 0L
        var left = 0
        for (right in nums.indices) {
            if (!(minK <= nums[right] && nums[right] <= maxK)) {
                left = right + 1
                continue
            }
            result += right - left + 1
        }
        return result
    }
}
