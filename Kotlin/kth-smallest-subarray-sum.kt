package kthsmallestsubarraysum

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun kthSmallestSubarraySum(nums: IntArray, k: Int): Int {
        var left = nums.min()
        var right = nums.sum()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(nums, k, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun check(nums: IntArray, k: Int, x: Int): Boolean {
        var cnt = 0
        var curr = 0
        var left = 0
        for (right in nums.indices) {
            curr += nums[right]
            while (curr > x) {
                curr -= nums[left++]
            }
            cnt += right - left + 1
        }
        return cnt >= k
    }
}
