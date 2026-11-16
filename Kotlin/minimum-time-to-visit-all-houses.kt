package minimumtimetovisitallhouses

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun minTotalTime(forward: IntArray, backward: IntArray, queries: IntArray): Long {
        val forwardPrefix = LongArray(2 * forward.size)
        for (i in 0 until 2 * forward.size - 1) {
            forwardPrefix[i + 1] = forwardPrefix[i] + forward[i % forward.size]
        }
        val backwardPrefix = LongArray(2 * backward.size)
        for (i in 0 until 2 * backward.size - 1) {
            backwardPrefix[i + 1] = backwardPrefix[i] + backward[i % backward.size]
        }
        var result = 0L
        var previous = 0
        for (query in queries) {
            result += if (previous > query) {
                minOf(
                    forwardPrefix[query + forward.size] - forwardPrefix[previous],
                    backwardPrefix[previous + 1] - backwardPrefix[query + 1]
                )
            } else {
                minOf(
                    forwardPrefix[query] - forwardPrefix[previous],
                    backwardPrefix[previous + forward.size + 1] - backwardPrefix[query + 1]
                )
            }
            previous = query
        }
        return result
    }
}
