package maximizetheprofitasthesalesman

// Time:  O(n + m), m = len(offers)
// Space: O(n + m)

class Solution {
    fun maximizeTheProfit(n: Int, offers: Array<IntArray>): Int {
        val lookup = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (x in offers) {
            lookup[x[1]].add(x[0] to x[2])
        }
        val dp = IntArray(n + 1)
        for (e in 0 until n) {
            dp[e + 1] = dp[e]
            for ((s, g) in lookup[e]) {
                dp[e + 1] = maxOf(dp[e + 1], dp[s] + g)
            }
        }
        return dp[n]
    }
}
