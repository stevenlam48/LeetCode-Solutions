package minimumdifferencebetweenlargestandsmallestvalueinthreemoves
// Time:  O(n + klogk)
// Space: O(1)

class Solution {
    fun minDifference(nums: IntArray): Int {
        val k = 4
        if (nums.size <= k) {
            return 0
        }
        nums.sort()
        var result = Int.MAX_VALUE
        for (i in 0 until k) {
            result = minOf(result, nums[nums.size - k + i] - nums[i])
        }
        return result
    }
}
