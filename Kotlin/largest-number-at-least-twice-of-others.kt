package largestnumberatleasttwiceofothers

// Time:  O(n)
// Space: O(1)

class Solution {
    fun dominantIndex(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            if (nums[i] > nums[result]) {
                result = i
            }
        }
        for (i in nums.indices) {
            if (i != result && 2 * nums[i] > nums[result]) {
                return -1
            }
        }
        return result
    }
}
