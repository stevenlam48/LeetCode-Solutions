package specialarrayi

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isArraySpecial(nums: IntArray): Boolean {
        for (i in 0 until nums.size - 1) {
            if ((nums[i] and 1) == (nums[i + 1] and 1)) {
                return false
            }
        }
        return true
    }
}
