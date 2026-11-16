package applyoperationstomakeallarrayelementsequaltozero

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkArray(nums: IntArray, k: Int): Boolean {
        var curr = 0
        for (i in nums.indices) {
            if (nums[i] - curr < 0) {
                return false
            }
            nums[i] -= curr
            curr += nums[i]
            if (i - (k - 1) >= 0) {
                curr -= nums[i - (k - 1)]
            }
        }
        return curr == 0
    }
}
