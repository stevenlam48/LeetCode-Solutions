package numberofzigzagarraysi

// Time:  O(n * (r - l))
// Space: O(r - l)

class Solution {
    fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val mod = 1_000_000_007
        val size = r - l
        val dp = IntArray(size + 1) { 1 }
        for (iteration in 0 until n - 1) {
            var prefix = 0
            for (i in dp.indices) {
                val current = dp[i]
                dp[i] = prefix
                prefix = (prefix + current) % mod
            }
            dp.reverse()
        }
        var result = 0
        for (x in dp) {
            result = (result + x) % mod
        }
        return result * 2 % mod
    }
}
