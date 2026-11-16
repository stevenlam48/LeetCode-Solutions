package minimumskipstoarriveatmeetingontime

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minSkips(dist: IntArray, speed: Int, hoursBefore: Int): Int {
        val dp = IntArray((dist.size - 1) + 1)
        for (i in dist.indices) {
            for (j in dp.size - 1 downTo 0) {
                dp[j] = if (i < dist.size - 1) ceil(dp[j] + dist[i], speed) * speed else dp[j] + dist[i]
                if (j - 1 >= 0) {
                    dp[j] = minOf(dp[j], dp[j - 1] + dist[i])
                }
            }
        }
        val target = hoursBefore.toLong() * speed
        for (i in dist.indices) {
            if (dp[i] <= target) {
                return i
            }
        }
        return -1
    }

    private fun ceil(a: Int, b: Int): Int {
        return (a + b - 1) / b
    }
}
