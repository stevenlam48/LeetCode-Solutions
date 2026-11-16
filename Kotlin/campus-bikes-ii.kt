package campusbikesii

// Time:  O(w * b * 2^b)
// Space: O(w * b * 2^b)

class Solution {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
        val dp = Array(2) { DoubleArray(1 shl bikes.size) { Double.POSITIVE_INFINITY } }
        dp[0][0] = 0.0
        for (i in workers.indices) {
            dp[(i + 1) % 2] = DoubleArray(1 shl bikes.size) { Double.POSITIVE_INFINITY }
            for (j in bikes.indices) {
                for (taken in 0 until (1 shl bikes.size)) {
                    if (taken and (1 shl j) != 0) {
                        continue
                    }
                    dp[(i + 1) % 2][taken or (1 shl j)] =
                        minOf(dp[(i + 1) % 2][taken or (1 shl j)],
                            dp[i % 2][taken] + manhattan(workers[i], bikes[j]))
                }
            }
        }
        return dp[workers.size % 2].minOrNull()!!.toInt()
    }

    private fun manhattan(p1: IntArray, p2: IntArray): Int {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])
    }
}
