package countsteppingnumbersinrange

// Time:  O(n)
// Space: O(1)

// dp
class Solution {
    fun countSteppingNumbers(low: String, high: String): Int {
        val MOD = 1_000_000_007

        val f = { s: String ->
            val dp = Array(2) { IntArray(10) }
            for (j in 1..(s[0] - '0')) {
                dp[0][j] = 1
            }
            var prefix = true
            for (i in 1 until s.length) {
                for (j in 0..9) {
                    dp[i % 2][j] = if (j != 0) 1 else 0
                    if (j - 1 >= 0) {
                        dp[i % 2][j] = (dp[i % 2][j] + (((dp[(i - 1) % 2][j - 1] - (if (prefix && (s[i - 1] - '0') == j - 1 && j > s[i] - '0') 1 else 0)) % MOD + MOD) % MOD)) % MOD
                    }
                    if (j + 1 < 10) {
                        dp[i % 2][j] = (dp[i % 2][j] + (((dp[(i - 1) % 2][j + 1] - (if (prefix && (s[i - 1] - '0') == j + 1 && j > s[i] - '0') 1 else 0)) % MOD + MOD) % MOD)) % MOD
                    }
                }
                if (kotlin.math.abs(s[i] - s[i - 1]) != 1) {
                    prefix = false
                }
            }
            var total = 0
            for (x in dp[(s.length - 1) % 2]) {
                total = (total + x) % MOD
            }
            total
        }

        val check = { s: String ->
            var ok = true
            for (i in 0 until s.length - 1) {
                if (kotlin.math.abs(s[i + 1] - s[i]) != 1) {
                    ok = false
                    break
                }
            }
            ok
        }

        return ((((f(high) - f(low)) % MOD + MOD) % MOD) + (if (check(low)) 1 else 0)) % MOD
    }
}
