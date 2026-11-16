package maximumearningsfromtaxi
// Time:  O(n + mlogm), m is the number of rides
// Space: O(n)

class Solution {
    fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
        rides.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] }.thenBy { it[2] })
        val dp = LongArray(n + 1)
        var j = 0
        for (i in 1..n) {
            dp[i] = maxOf(dp[i], dp[i - 1])
            while (j < rides.size && rides[j][0] == i) {
                val end = rides[j][1]
                dp[end] = maxOf(dp[end], dp[i] + rides[j][1].toLong() - rides[j][0] + rides[j][2])
                ++j
            }
        }
        return dp.last()
    }
}
