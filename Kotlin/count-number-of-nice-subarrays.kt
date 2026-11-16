package countnumberofnicesubarrays

// Time:  O(n)
// Space: O(k)

class Solution {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        return atMostK(nums, k) - atMostK(nums, k - 1)
    }

    private fun atMostK(nums: IntArray, k: Int): Int {
        if (k < 0) {
            return 0
        }
        var result = 0
        var left = 0
        var count = 0
        for (right in nums.indices) {
            count += nums[right] % 2
            while (count > k) {
                count -= nums[left] % 2
                ++left
            }
            result += right - left + 1
        }
        return result
    }
}
