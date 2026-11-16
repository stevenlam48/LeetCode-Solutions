package distinctsubsequencesii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun distinctSubseqII(s: String): Int {
        val mod = 1_000_000_007
        val dp = IntArray(26)
        var result = 0
        for (c in s) {
            val index = c - 'a'
            val delta = ((result + 1) - dp[index] + mod) % mod
            val next = (result + 1) % mod
            result = (result + delta) % mod
            dp[index] = next
        }
        return result
    }
}
