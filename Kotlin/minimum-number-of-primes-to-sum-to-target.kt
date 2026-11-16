package minimumnumberofprimestosumtotarget

// Time:  O(min(mlogm, n) + nlog(log(min(mlogm, n))) + m * n) = O(nlog(log(min(m, n))) + m * n)
// Space: O(n)

class Solution {
    fun minNumberOfPrimes(n: Int, m: Int): Int {
        val inf = Int.MAX_VALUE
        val isPrime = BooleanArray(n + 1) { true }
        val dp = IntArray(n + 1) { inf }
        dp[0] = 0
        var cnt = 0
        for (i in 2..n) {
            if (!isPrime[i]) {
                continue
            }
            var multiple = i + i
            while (multiple <= n) {
                isPrime[multiple] = false
                multiple += i
            }
            for (j in i..n) {
                if (dp[j - i] != inf) {
                    dp[j] = minOf(dp[j], dp[j - i] + 1)
                }
            }
            if (++cnt == m) {
                break
            }
        }
        return if (dp[n] != inf) dp[n] else -1
    }
}
