package formlargestintegerwithdigitsthatadduptotarget

// Time:  O(t)
// Space: O(t)

class Solution {
    fun largestNumber(cost: IntArray, target: Int): String {
        val dp = IntArray(target + 1) { -1 }
        dp[0] = 0
        for (t in 1..target) {
            for (i in 0 until 9) {
                if (t < cost[i] || dp[t - cost[i]] < 0) {
                    continue
                }
                dp[t] = maxOf(dp[t], dp[t - cost[i]] + 1)
            }
        }
        if (dp[target] < 0) {
            return "0"
        }
        val result = StringBuilder()
        var remaining = target
        for (i in 8 downTo 0) {
            while (remaining >= cost[i] && dp[remaining] == dp[remaining - cost[i]] + 1) {
                remaining -= cost[i]
                result.append('1' + i)
            }
        }
        return result.toString()
    }
}
