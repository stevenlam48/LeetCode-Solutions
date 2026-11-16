package greatestsumdivisiblebythree

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSumDivThree(nums: IntArray): Int {
        var dp = IntArray(3)
        for (num in nums) {
            val newDp = dp.copyOf()
            for (i in dp.indices) {
                dp[i] += num
            }
            for (i in dp) {
                newDp[i % 3] = maxOf(newDp[i % 3], i)
            }
            dp = newDp
        }
        return dp[0]
    }
}
