package freedomtrail

// Time:  O(k) ~ O(k * r^2)
// Space: O(r)

class Solution {
    fun findRotateSteps(ring: String, key: String): Int {
        val lookup = HashMap<Char, MutableList<Int>>()
        for (i in ring.indices) {
            lookup.getOrPut(ring[i]) { mutableListOf() }.add(i)
        }

        val dp = Array(2) { IntArray(ring.length) }
        for (i in 1..key.length) {
            dp[i % 2].fill(Int.MAX_VALUE)
            for (j in lookup[key[i - 1]].orEmpty()) {
                val previous = if (i > 1) lookup[key[i - 2]].orEmpty() else listOf(0)
                for (k in previous) {
                    val minDist = minOf(
                        (k + ring.length - j) % ring.length,
                        (j + ring.length - k) % ring.length
                    ) + dp[(i - 1) % 2][k]
                    dp[i % 2][j] = minOf(dp[i % 2][j], minDist)
                }
            }
        }
        return dp[key.length % 2].minOrNull()!! + key.length
    }
}
