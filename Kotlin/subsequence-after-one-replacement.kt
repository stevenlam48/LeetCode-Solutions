package subsequenceafteronereplacement

// Time:  O(n + m)
// Space: O(1)

// dp
class Solution {
    fun canMakeSubsequence(s: String, t: String): Boolean {
        val dp = IntArray(2)
        for (x in t) {
            if (dp[1] < s.length && s[dp[1]] == x) {
                ++dp[1]
            }
            dp[1] = maxOf(dp[1], dp[0] + 1)
            if (dp[1] == s.length) {
                return true
            }
            if (dp[0] < s.length && s[dp[0]] == x) {
                ++dp[0]
            }
        }
        return false
    }
}
