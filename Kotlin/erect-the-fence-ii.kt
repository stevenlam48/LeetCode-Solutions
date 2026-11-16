package erectthefenceii

import kotlin.math.sqrt

// Time:  O(n) on average
// Space: O(n)
class Solution {
    fun outerTrees(trees: Array<IntArray>): DoubleArray {
        trees.shuffle()
        val boundaries = mutableListOf<DoubleArray>()
        val result = welzl(trees, boundaries, 0)
        return doubleArrayOf(result.first[0], result.first[1], result.second)
    }

    private fun welzl(
        points: Array<IntArray>,
        boundaries: MutableList<DoubleArray>,
        curr: Int
    ): Pair<DoubleArray, Double> {
        if (curr == points.size || boundaries.size == 3) {
            return trivial(boundaries)
        }
        val p = doubleArrayOf(points[curr][0].toDouble(), points[curr][1].toDouble())
        val result = welzl(points, boundaries, curr + 1)
        if (result.first.isNotEmpty() && inside(result, p)) {
            return result
        }
        boundaries.add(p)
        val result2 = welzl(points, boundaries, curr + 1)
        boundaries.removeAt(boundaries.size - 1)
        return result2
    }

    private fun trivial(boundaries: List<DoubleArray>): Pair<DoubleArray, Double> {
        if (boundaries.isEmpty()) {
            return Pair(DoubleArray(0), 0.0)
        }
        if (boundaries.size == 1) {
            return Pair(boundaries[0], 0.0)
        }
        if (boundaries.size == 2) {
            return circleFrom2Points(boundaries[0], boundaries[1])
        }
        return circleFrom3Points(boundaries[0], boundaries[1], boundaries[2])
    }

    private fun dist(a: DoubleArray, b: DoubleArray): Double {
        return sqrt((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]))
    }

    private fun inside(c: Pair<DoubleArray, Double>, p: DoubleArray): Boolean {
        val EPS = 1e-5
        return dist(c.first, p) < c.second + EPS
    }

    private fun circleCenter(bx: Int, by: Int, cx: Int, cy: Int): DoubleArray {
        val b = (bx * bx + by * by).toDouble()
        val c = (cx * cx + cy * cy).toDouble()
        val d = (bx * cy - by * cx).toDouble()
        return doubleArrayOf((cy * b - by * c) / (2 * d), (bx * c - cx * b) / (2 * d))
    }

    private fun circleFrom2Points(a: DoubleArray, b: DoubleArray): Pair<DoubleArray, Double> {
        val c = doubleArrayOf((a[0] + b[0]) / 2.0, (a[1] + b[1]) / 2.0)
        return Pair(c, dist(a, b) / 2.0)
    }

    private fun circleFrom3Points(a: DoubleArray, b: DoubleArray, c: DoubleArray): Pair<DoubleArray, Double> {
        val i = circleCenter(
            (b[0] - a[0]).toInt(), (b[1] - a[1]).toInt(),
            (c[0] - a[0]).toInt(), (c[1] - a[1]).toInt()
        )
        i[0] += a[0]
        i[1] += a[1]
        return Pair(i, dist(i, a))
    }
}
