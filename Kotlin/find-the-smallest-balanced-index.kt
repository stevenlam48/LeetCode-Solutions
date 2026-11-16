package findthesmallestbalancedindex

// Time:  O(n)
// Space: O(1)

// prefix sum
class Solution {
    fun smallestBalancedIndex(nums: IntArray): Int {
        var left = 0L
        for (x in nums) {
            left += x
        }
        var right = 1L
        var i = nums.size - 1
        while (i >= 0) {
            left -= nums[i]
            if (left < right) {
                break
            }
            if (left == right) {
                return i
            }
            right *= nums[i]
            --i
        }
        return -1
    }
}
