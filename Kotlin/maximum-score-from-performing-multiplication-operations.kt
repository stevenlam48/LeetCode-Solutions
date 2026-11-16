package maximumscorefromperformingmultiplicationoperations

// Time:  O(m^2)
// Space: O(m)

class Solution {
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        var dp = IntArray(multipliers.size + 1)
        var l = nums.size - multipliers.size
        for (i in multipliers.indices.reversed()) {
            val newDp = IntArray(dp.size - 1)
            for (j in newDp.indices) {
                newDp[j] = maxOf(
                    multipliers[i] * nums[j] + dp[j + 1],
                    multipliers[i] * nums[j + l] + dp[j]
                )
            }
            dp = newDp
            l++
        }
        return dp[0]
    }
}
