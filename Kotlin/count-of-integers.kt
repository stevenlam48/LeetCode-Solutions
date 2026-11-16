package countofintegers

// Time:  O(n * m), m = max_sum
// Space: O(m)
class Solution {
    fun count(num1: String, num2: String, min_sum: Int, max_sum: Int): Int {
        val mod = 1_000_000_007

        fun check(x: String): Int {
            var total = 0
            for (c in x) {
                total += c - '0'
            }
            return if (min_sum <= total && total <= max_sum) 1 else 0
        }

        fun f(x: String): Int {
            var dp = Array(2) { IntArray(max_sum + 1) }
            dp[0][0] = 1
            dp[1][0] = 1
            for (i in x.lastIndex downTo 0) {
                val newDp = Array(2) { IntArray(max_sum + 1) }
                for (t in 0 until 2) {
                    for (total in 0..max_sum) {
                        val digit = x[i] - '0'
                        for (d in 0..minOf(if (t == 1) digit else 9, total)) {
                            val tight = if (t == 1 && d == digit) 1 else 0
                            newDp[t][total] = (newDp[t][total] + dp[tight][total - d]) % mod
                        }
                    }
                }
                dp = newDp
            }
            var result = 0
            for (total in min_sum..max_sum) {
                result = (result + dp[1][total]) % mod
            }
            return result
        }

        return (((f(num2) - f(num1)) % mod + mod) % mod + check(num1)) % mod
    }
}
