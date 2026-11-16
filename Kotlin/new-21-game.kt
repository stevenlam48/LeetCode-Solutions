package new21game
// Time:  O(n)
// Space: O(n)

class Solution {
    fun new21Game(N: Int, K: Int, W: Int): Double {
        if (K == 0 || N >= K + W) {
            return 1.0
        }
        val dp = DoubleArray(N + 1)
        dp[0] = 1.0
        var windowSum = 1.0
        var result = 0.0
        for (i in 1..N) {
            dp[i] = windowSum / W
            if (i < K) {
                windowSum += dp[i]
            } else {
                result += dp[i]
            }
            if (i - W >= 0) {
                windowSum -= dp[i - W]
            }
        }
        return result
    }
}
