package checkifitispossibletosplitarray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun canSplitArray(nums: IntArray, m: Int): Boolean {
        if (nums.size <= 2) {
            return true
        }
        for (i in 0 until nums.size - 1) {
            if (nums[i] + nums[i + 1] >= m) {
                return true
            }
        }
        return false
    }
}
