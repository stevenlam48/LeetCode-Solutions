package countwaystobuildgoodstrings

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val mod = 1_000_000_007

        var result = 0
        val dp = IntArray(high + 1)
        dp[0] = 1
        for (i in 1..high) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % mod
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % mod
            }
            if (i >= low) {
                result = (result + dp[i]) % mod
            }
        }
        return result
    }
}
