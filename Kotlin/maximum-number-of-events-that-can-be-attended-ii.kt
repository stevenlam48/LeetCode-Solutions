package maximumnumberofeventsthatcanbeattendedii

// Time:  O(nlogn + n * k)
// Space: O(n * k)

class Solution {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        events.sortWith(compareBy { it[1] })
        val n = events.size
        val dp = Array(n + 1) { IntArray(k + 1) }
        for (i in 1..n) {
            var lo = 0
            var hi = n
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (events[mid][1] < events[i - 1][0]) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            val prevIndex = lo
            for (j in 1..k) {
                dp[i][j] = maxOf(
                    dp[i - 1][j],
                    dp[prevIndex][j - 1] + events[i - 1][2]
                )
            }
        }
        return dp[n][k]
    }
}
