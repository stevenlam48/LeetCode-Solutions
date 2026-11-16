package maximumalternatingsubsequencesum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxAlternatingSum(nums: IntArray): Long {
        var result = nums[0].toLong()
        for (i in 0 until nums.size - 1) {
            result += maxOf(nums[i + 1] - nums[i], 0)
        }
        return result
    }
}
