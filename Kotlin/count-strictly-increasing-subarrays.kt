package countstrictlyincreasingsubarrays

// Time:  O(n)
// Space: O(1)

// two pointers
class Solution {
    fun countSubarrays(nums: IntArray): Long {
        var result = 1L
        var l = 1L
        for (i in 1 until nums.size) {
            if (nums[i - 1] >= nums[i]) {
                l = 0
            }
            result += ++l
        }
        return result
    }
}
