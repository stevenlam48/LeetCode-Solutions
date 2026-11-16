package minimumsizesubarraysum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        var start = -1
        var sum = 0
        var minSize = Int.MAX_VALUE
        for (i in nums.indices) {
            sum += nums[i]
            while (sum >= s) {
                minSize = minOf(minSize, i - start)
                sum -= nums[++start]
            }
        }
        if (minSize == Int.MAX_VALUE) {
            return 0
        }
        return minSize
    }
}
