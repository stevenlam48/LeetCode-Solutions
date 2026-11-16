package minimumtimetofinishtherace

// Time:  O((n + l) * logc)
// Space: O(n + l + logc)

class Solution {
    fun minimumFinishTime(tires: Array<IntArray>, changeTime: Int, numLaps: Int): Int {
        val infinity = Int.MAX_VALUE.toLong()
        val size = 32 - (changeTime).countLeadingZeroBits()
        val dp = LongArray(size) { infinity }
        for (tire in tires) {
            val f = tire[0]
            val r = tire[1]
            var current = f.toLong()
            var total = f.toLong()
            var count = 0
            while (current < changeTime.toLong() + f) {
                dp[count] = minOf(dp[count], total)
                current *= r
                total += current
                ++count
            }
        }
        val race = LongArray(numLaps) { infinity }
        for (i in 0 until numLaps) {
            for (j in 0 until minOf(i + 1, dp.size)) {
                val previous = if (i - j - 1 >= 0) race[i - j - 1] + changeTime else 0L
                race[i] = minOf(race[i], previous + dp[j])
            }
        }
        return race.last().toInt()
    }
}
