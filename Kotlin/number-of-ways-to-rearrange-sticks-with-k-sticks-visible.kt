package numberofwaystorearrangestickswithksticksvisible

// Time:  O(n * k)
// Space: O(k)

class Solution {
    fun rearrangeSticks(n: Int, k: Int): Int {
        val mod = 1_000_000_007L
        val dp = Array(2) { IntArray(k + 1) }
        dp[1][1] = 1
        for (i in 2..n) {
            for (j in 1..minOf(i, k)) {
                dp[i % 2][j] = ((dp[(i - 1) % 2][j - 1] +
                    (i - 1).toLong() * dp[(i - 1) % 2][j]) % mod).toInt()
            }
        }
        return dp[n % 2][k]
    }
}
