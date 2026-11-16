package minimizemanhattandistances
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumDistance(points: Array<IntArray>): Int {
        fun maxDistance(exclude: Int): Triple<Int, Int, Int> {
            var maxSum = Int.MIN_VALUE to -1
            var minSum = Int.MAX_VALUE to -1
            var maxDiff = Int.MIN_VALUE to -1
            var minDiff = Int.MAX_VALUE to -1
            for (i in points.indices) {
                if (i == exclude) {
                    continue
                }
                val x = points[i][0]
                val y = points[i][1]
                val sum = x + y
                val diff = x - y
                if (sum > maxSum.first || (sum == maxSum.first && i > maxSum.second)) {
                    maxSum = sum to i
                }
                if (sum < minSum.first || (sum == minSum.first && i < minSum.second)) {
                    minSum = sum to i
                }
                if (diff > maxDiff.first || (diff == maxDiff.first && i > maxDiff.second)) {
                    maxDiff = diff to i
                }
                if (diff < minDiff.first || (diff == minDiff.first && i < minDiff.second)) {
                    minDiff = diff to i
                }
            }
            val bySum = Triple(maxSum.first - minSum.first, maxSum.second, minSum.second)
            val byDiff = Triple(maxDiff.first - minDiff.first, maxDiff.second, minDiff.second)
            return if (bySum.first > byDiff.first ||
                (bySum.first == byDiff.first && bySum.second > byDiff.second) ||
                (bySum.first == byDiff.first && bySum.second == byDiff.second && bySum.third >= byDiff.third)
            ) bySum else byDiff
        }

        val distance = maxDistance(-1)
        return minOf(maxDistance(distance.second).first, maxDistance(distance.third).first)
    }
}
