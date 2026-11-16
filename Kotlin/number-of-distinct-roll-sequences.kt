package numberofdistinctrollsequences

// Time:  O(6^3 * n)
// Space: O(6^2)

class Solution {
    fun distinctSequences(n: Int): Int {
        if (n == 1) {
            return 6
        }
        var dp = Array(6) { IntArray(6) }
        for (i in 0 until 6) {
            for (j in 0 until 6) {
                if (i != j && gcd(i + 1, j + 1) == 1) {
                    dp[i][j] = 1
                }
            }
        }
        for (iteration in 0 until n - 2) {
            val newDp = Array(6) { IntArray(6) }
            for (i in 0 until 6) {
                for (j in 0 until 6) {
                    if (dp[i][j] == 0) {
                        continue
                    }
                    for (k in 0 until 6) {
                        if (dp[j][k] == 0) {
                            continue
                        }
                        if (k != i) {
                            newDp[i][j] = (newDp[i][j] + dp[j][k]) % MOD
                        }
                    }
                }
            }
            dp = newDp
        }
        var result = 0
        for (row in dp) {
            for (value in row) {
                result = (result + value) % MOD
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val remainder = x % y
            x = y
            y = remainder
        }
        return x
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
