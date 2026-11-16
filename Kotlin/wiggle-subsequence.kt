package wigglesubsequence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.size < 2) {
            return nums.size
        }

        var length = 1
        var up = 0

        for (i in 1 until nums.size) {
            if (nums[i - 1] < nums[i] && (up == 0 || up == 1)) {
                ++length
                up = -1
            } else if (nums[i - 1] > nums[i] && (up == 0 || up == -1)) {
                ++length
                up = 1
            }
        }

        return length
    }
}
