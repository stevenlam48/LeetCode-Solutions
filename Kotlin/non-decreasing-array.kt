package nondecreasingarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkPossibility(nums: IntArray): Boolean {
        var cnt = 0
        var prev = nums[0]
        for (i in 1 until nums.size) {
            if (prev > nums[i]) {
                if (cnt++ > 0) {
                    return false
                }
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    prev = nums[i]
                }
            } else {
                prev = nums[i]
            }
        }
        return true
    }
}
