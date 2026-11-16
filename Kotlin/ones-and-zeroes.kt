package onesandzeroes

// Time:  O(s * m * n), s is the size of the array.
// Space: O(m * n)

class Solution {
    fun findMaxForm(strs: List<String>, m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (str in strs) {
            var zeroCount = 0
            var oneCount = 0
            for (c in str) {
                if (c == '0') {
                    ++zeroCount
                } else if (c == '1') {
                    ++oneCount
                }
            }

            var i = m
            while (i - zeroCount >= 0) {
                var j = n
                while (j - oneCount >= 0) {
                    dp[i][j] = maxOf(dp[i][j], dp[i - zeroCount][j - oneCount] + 1)
                    --j
                }
                --i
            }
        }
        return dp[m][n]
    }
}
