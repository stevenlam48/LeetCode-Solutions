package numberofwaysofcuttingapizza

// Time:  O(m * n * k * (m + n))
// Space: O(m * n * k)

class Solution {
    fun ways(pizza: List<String>, k: Int): Int {
        val MOD = 1_000_000_007
        val m = pizza.size
        val n = pizza[0].length
        val prefix = Array(m) { IntArray(n) }
        for (j in n - 1 downTo 0) {
            var accu = 0
            for (i in m - 1 downTo 0) {
                if (pizza[i][j] == 'A') {
                    ++accu
                }
                prefix[i][j] = (if (j + 1 != n) prefix[i][j + 1] else 0) + accu
            }
        }
        val dp = Array(m) { Array(n) { LongArray(k) } }
        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                dp[i][j][0] = 1
                for (mm in 1 until k) {
                    var nn = i + 1
                    while (nn < m && prefix[nn][j] != 0) {
                        if (prefix[i][j] != prefix[nn][j]) {
                            dp[i][j][mm] = (dp[i][j][mm] + dp[nn][j][mm - 1]) % MOD
                        }
                        ++nn
                    }
                    nn = j + 1
                    while (nn < n && prefix[i][nn] != 0) {
                        if (prefix[i][j] != prefix[i][nn]) {
                            dp[i][j][mm] = (dp[i][j][mm] + dp[i][nn][mm - 1]) % MOD
                        }
                        ++nn
                    }
                }
            }
        }
        return dp[0][0][k - 1].toInt()
    }
}
