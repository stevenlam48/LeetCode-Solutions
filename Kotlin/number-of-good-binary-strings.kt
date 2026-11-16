package numberofgoodbinarystrings

// Time:  O(n), n = maxLength
// Space: O(w), w = max(oneGroup, zeroGroup)+1

// dp
class Solution {
    fun goodBinaryStrings(minLength: Int, maxLength: Int, oneGroup: Int, zeroGroup: Int): Int {
        val MOD = 1_000_000_007

        var result = 0
        val w = maxOf(oneGroup, zeroGroup) + 1
        val dp = IntArray(w)
        for (i in 0..maxLength) {
            dp[i % w] = if (i == 0) 1 else 0
            if (i - oneGroup >= 0) {
                dp[i % w] = (dp[i % w] + dp[(i - oneGroup) % w]) % MOD
            }
            if (i - zeroGroup >= 0) {
                dp[i % w] = (dp[i % w] + dp[(i - zeroGroup) % w]) % MOD
            }
            if (i >= minLength) {
                result = (result + dp[i % w]) % MOD
            }
        }
        return result
    }
}
