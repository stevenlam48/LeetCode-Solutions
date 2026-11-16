package lexicographicallysmalleststringafteradjacentremovals

// Time:  O(n^3)
// Space: O(n^2)
class Solution {
    fun lexicographicallySmallestString(s: String): String {
        val dp = Array(s.length) { BooleanArray(s.length) }
        for (length in 2..s.length step 2) {
            for (i in 0..s.length - length) {
                val j = i + length - 1
                val difference = kotlin.math.abs(s[i] - s[j])
                if (difference == 1 || difference == 25) {
                    if (j == i + 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true
                        continue
                    }
                }
                for (k in i + 1 until j step 2) {
                    if (dp[i][k] && dp[k + 1][j]) {
                        dp[i][j] = true
                        break
                    }
                }
            }
        }
        val dp2 = Array(s.length + 1) { "" }
        for (i in s.length - 1 downTo 0) {
            dp2[i] = s[i] + dp2[i + 1]
            for (j in i + 1 until s.length step 2) {
                if (dp[i][j] && dp2[j + 1] < dp2[i]) {
                    dp2[i] = dp2[j + 1]
                }
            }
        }
        return dp2[0]
    }
}
