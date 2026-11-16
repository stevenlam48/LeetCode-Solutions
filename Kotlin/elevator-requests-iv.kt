package elevatorrequestsiv

// Time:  O(m^2), m = len(requests)
// Space: O(m)

import kotlin.math.abs

class Solution {
    fun elevatorRequests(n: Int, start: Int, requests: Array<IntArray>): Int {
        val lookup = HashMap<Int, Int>()
        for (x in requests) {
            lookup[x[1]] = maxOf(lookup[x[1]] ?: 0, x[0])
        }
        val pairs = lookup.toList().sortedBy { it.first }
        if (pairs.size == 1) {
            return maxOf(abs(start - pairs[0].first).toLong(), pairs[0].second.toLong()).toInt()
        }
        var dp = Array(2) { LongArray(pairs.size) { Long.MAX_VALUE } }
        dp[0][1] = maxOf(abs(start - pairs[0].first).toLong(), pairs[0].second.toLong())
        dp[1][0] = maxOf(abs(start - pairs.last().first).toLong(), pairs.last().second.toLong())
        var result = Long.MAX_VALUE
        for (l in pairs.size - 1 downTo 1) {
            val newDp = Array(2) { LongArray(pairs.size) { Long.MAX_VALUE } }
            for (i in 0..pairs.size - l) {
                val j = i + l - 1
                for (s in 0 until 2) {
                    if (dp[s][i] == Long.MAX_VALUE) {
                        continue
                    }
                    val x = if (s == 0) pairs[i - 1].first else pairs[j + 1].first
                    if (l == 1) {
                        result = minOf(
                            result,
                            maxOf(dp[s][i] + abs(x - pairs[i].first), pairs[i].second.toLong())
                        )
                        continue
                    }
                    newDp[0][i + 1] = minOf(
                        newDp[0][i + 1],
                        maxOf(dp[s][i] + abs(x - pairs[i].first), pairs[i].second.toLong())
                    )
                    newDp[1][i] = minOf(
                        newDp[1][i],
                        maxOf(dp[s][i] + abs(x - pairs[j].first), pairs[j].second.toLong())
                    )
                }
            }
            dp = newDp
        }
        return result.toInt()
    }
}
