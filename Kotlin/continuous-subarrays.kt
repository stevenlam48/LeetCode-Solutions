package continuoussubarrays
// Time:  O(n)
// Space: O(1)

class Solution {
    fun continuousSubarrays(nums: IntArray): Long {
        var result = 0L
        var mn = Int.MAX_VALUE
        var mx = Int.MIN_VALUE
        var left = 0
        for (right in nums.indices) {
            if (mn <= nums[right] && nums[right] <= mx) {
                mn = maxOf(mn, nums[right] - 2)
                mx = minOf(mx, nums[right] + 2)
            } else {
                mn = nums[right] - 2
                mx = nums[right] + 2
                left = right - 1
                while (left >= 0) {
                    if (!(mn <= nums[left] && nums[left] <= mx)) {
                        break
                    }
                    mn = maxOf(mn, nums[left] - 2)
                    mx = minOf(mx, nums[left] + 2)
                    --left
                }
                ++left
            }
            result += right - left + 1
        }
        return result
    }
}
