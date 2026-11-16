package allocatemailboxes

// Time:  O(m * n^2)
// Space: O(n)

class Solution {
    fun minDistance(houses: IntArray, k: Int): Int {
        houses.sort()
        val prefix = IntArray(houses.size + 1)
        for (i in houses.indices) {
            prefix[i + 1] = prefix[i] + houses[i]
        }
        val dp = IntArray(houses.size)
        for (j in houses.indices) {
            dp[j] = cost(prefix, 0, j)
        }
        for (m in 1 until k) {
            for (j in houses.size - 1 downTo 0) {
                for (i in m..j) {
                    dp[j] = minOf(dp[j], dp[i - 1] + cost(prefix, i, j))
                }
            }
        }
        return dp.last()
    }

    private fun cost(prefix: IntArray, i: Int, j: Int): Int {
        return (prefix[j + 1] - prefix[(i + j + 1) / 2]) -
            (prefix[(i + j) / 2 + 1] - prefix[i])
    }
}
