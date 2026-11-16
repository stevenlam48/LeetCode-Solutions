package missingelementinsortedarray
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun missingElement(nums: IntArray, k: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(nums, k, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return nums[right] + (k - missingCount(nums, right))
    }

    private fun missingCount(nums: IntArray, x: Int): Int {
        return (nums[x] - nums[0] + 1) - (x + 1)
    }

    private fun check(nums: IntArray, k: Int, x: Int): Boolean {
        return k > missingCount(nums, x)
    }
}
