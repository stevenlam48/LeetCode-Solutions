package countdistinctwaystoformtargetfromtwostrings

// Time:  O(n * m * t)
// Space: O(n * m)

// dp, prefix sum
class Solution {
    fun interleaveCharacters(word1: String, word2: String, target: String): Int {
        val mod = 1_000_000_007
        val n = word1.length
        val m = word2.length
        var dp = Array(n + 1) { IntArray(m + 1) }
        dp[0][0] = 1
        for (c in target) {
            val newDp = Array(n + 1) { IntArray(m + 1) }
            val col = IntArray(m + 1)
            for (i in 0..n) {
                var row = 0
                for (j in 0..m) {
                    row = (row + dp[i][j]) % mod
                    if (j < m && word2[j] == c) {
                        newDp[i][j + 1] = (newDp[i][j + 1] + row) % mod
                    }
                    col[j] = (col[j] + dp[i][j]) % mod
                    if (i < n && word1[i] == c) {
                        newDp[i + 1][j] = (newDp[i + 1][j] + col[j]) % mod
                    }
                }
            }
            dp = newDp
        }
        var result = 0
        for (i in 1..n) {
            for (j in 1..m) {
                result = (result + dp[i][j]) % mod
            }
        }
        return result
    }
}
