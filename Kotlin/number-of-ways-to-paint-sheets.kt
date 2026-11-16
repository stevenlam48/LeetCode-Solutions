package numberofwaystopaintsheets

// Time:  O(mlogm)
// Space: O(m)

class Solution {
    fun numberOfWays(n: Int, limit: IntArray): Int {
        val mod = 1_000_000_007L
        limit.sort()
        val suffix = LongArray(limit.size + 1)
        for (i in limit.lastIndex downTo 0) {
            limit[i] = minOf(limit[i], n - 1)
            suffix[i] = suffix[i + 1] + limit[i]
        }
        var result = 0L
        var j = 0
        for (i in limit.lastIndex downTo 0) {
            while (j < limit.size) {
                if (limit[i] + limit[j] >= n) {
                    break
                }
                ++j
            }
            var count = (limit[i] - n + 1).toLong() * (limit.size - j) + suffix[j]
            if (i >= j) {
                count -= limit[i] + limit[i] - n + 1
            }
            result = (result + count) % mod
        }
        return result.toInt()
    }
}
