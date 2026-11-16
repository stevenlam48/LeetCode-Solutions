package maximumascendingsubarraysum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxAscendingSum(nums: IntArray): Int {
        var result = 0
        var curr = 0
        for (i in nums.indices) {
            if (!(i != 0 && nums[i - 1] < nums[i])) {
                curr = 0
            }
            curr += nums[i]
            result = maxOf(result, curr)
        }
        return result
    }
}
