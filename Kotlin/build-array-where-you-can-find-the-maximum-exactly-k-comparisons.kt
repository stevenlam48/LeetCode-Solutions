package buildarraywhereyoucanfindthemaximumexactlykcomparisons

// Time:  O(n * m * k)
// Space: O(m * k)

class Solution {
    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        val mod = 1_000_000_007L
        val dp = Array(2) { Array(m + 1) { LongArray(k + 1) } }
        val prefixDp = Array(2) { Array(m + 1) { LongArray(k + 1) } }
        for (i in 1..m) {
            dp[1][i][1] = 1
            prefixDp[1][i][1] = (prefixDp[1][i - 1][1] + dp[1][i][1]) % mod
        }
        for (l in 2..n) {
            for (i in 1..m) {
                for (j in 1..k) {
                    dp[l % 2][i][j] = (i * dp[(l - 1) % 2][i][j] % mod +
                        prefixDp[(l - 1) % 2][i - 1][j - 1]) % mod
                    prefixDp[l % 2][i][j] = (prefixDp[l % 2][i - 1][j] + dp[l % 2][i][j]) % mod
                }
            }
        }
        return prefixDp[n % 2][m][k].toInt()
    }
}
