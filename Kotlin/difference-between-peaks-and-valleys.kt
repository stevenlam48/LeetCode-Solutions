package differencebetweenpeaksandvalleys

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun peakValleyDifference(nums: IntArray): Int {
        var result = 0
        for (i in 1 until nums.size - 1) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                result += nums[i]
            } else if (nums[i - 1] > nums[i] && nums[i] < nums[i + 1]) {
                result -= nums[i]
            }
        }
        return result
    }
}
