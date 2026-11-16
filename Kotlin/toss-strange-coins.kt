package tossstrangecoins

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {
        val dp = DoubleArray(target + 1)
        dp[0] = 1.0
        for (p in prob) {
            for (i in target downTo 0) {
                dp[i] = (if (i >= 1) dp[i - 1] else 0.0) * p + dp[i] * (1 - p)
            }
        }
        return dp[target]
    }
}
