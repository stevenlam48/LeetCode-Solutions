package bestpositionforaservicecentre

// Time:  O(n * iter), iter is the number of iterations
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun getMinDistSum(positions: Array<IntArray>): Double {
        var median = (positions.sumOf { it[0].toDouble() } / positions.size) to
            (positions.sumOf { it[1].toDouble() } / positions.size)
        var previousMedian = -1.0 to -1.0
        while (previousMedian.first < 0 || norm(median, previousMedian) * positions.size > EPS) {
            val (stopped, newMedian) = geometryMedian(positions, median)
            if (stopped) {
                break
            }
            previousMedian = median
            median = newMedian
        }
        return positions.sumOf {
            norm(median, it[0].toDouble() to it[1].toDouble())
        }
    }

    private fun norm(p1: Pair<Double, Double>, p2: Pair<Double, Double>): Double {
        return sqrt(
            (p1.first - p2.first) * (p1.first - p2.first) +
                (p1.second - p2.second) * (p1.second - p2.second)
        )
    }

    private fun geometryMedian(
        positions: Array<IntArray>,
        median: Pair<Double, Double>
    ): Pair<Boolean, Pair<Double, Double>> {
        var numeratorX = 0.0
        var numeratorY = 0.0
        var denominator = 0.0
        for (p in positions) {
            val length = norm(median, p[0].toDouble() to p[1].toDouble())
            if (length == 0.0) {
                continue
            }
            numeratorX += p[0] / length
            numeratorY += p[1] / length
            denominator += 1 / length
        }
        if (denominator == 0.0) {
            return true to (0.0 to 0.0)
        }
        return false to ((numeratorX / denominator) to (numeratorY / denominator))
    }

    companion object {
        private const val EPS = 1e-6
    }
}
