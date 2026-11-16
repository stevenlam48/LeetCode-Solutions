package palindromeremoval
// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun minimumMoves(arr: IntArray): Int {
        val dp = Array(arr.size + 1) { IntArray(arr.size) }
        for (l in 1..arr.size) {
            for (i in 0..arr.size - l) {
                val j = i + l - 1
                if (l == 1) {
                    dp[i][j] = 1
                } else {
                    dp[i][j] = 1 + dp[i + 1][j]
                    if (arr[i] == arr[i + 1]) {
                        dp[i][j] = minOf(dp[i][j], 1 + dp[i + 2][j])
                    }
                    for (k in i + 2..j) {
                        if (arr[i] == arr[k]) {
                            dp[i][j] = minOf(dp[i][j], dp[i + 1][k - 1] + dp[k + 1][j])
                        }
                    }
                }
            }
        }
        return dp[0][arr.size - 1]
    }
}
