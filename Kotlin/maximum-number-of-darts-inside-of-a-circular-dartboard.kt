package maximumnumberofdartsinsideofacirculardartboard

import kotlin.math.acos
import kotlin.math.atan2
import kotlin.math.sqrt

// Time:  O(n^2 * logn)
// Space: O(n)

class Solution {
    fun numPoints(points: Array<IntArray>, r: Int): Int {
        var result = 0
        for (i in points.indices) {
            result = maxOf(result, countPoints(points, r, i))
        }
        return result
    }

    private fun countPoints(points: Array<IntArray>, r: Int, i: Int): Int {
        val angles = ArrayList<Pair<Double, Boolean>>()
        for (j in points.indices) {
            if (j == i) {
                continue
            }
            val dx = points[i][0] - points[j][0]
            val dy = points[i][1] - points[j][1]
            val d = sqrt((dx * dx + dy * dy).toDouble())
            if (d > 2 * r) {
                continue
            }
            val delta = acos(d / (2 * r))
            val angle = atan2(dy.toDouble(), dx.toDouble())
            angles.add(Pair(angle - delta, false))
            angles.add(Pair(angle + delta, true))
        }
        angles.sortWith(compareBy({ it.first }, { it.second }))
        var result = 1
        var count = 1
        for ((_, isClosed) in angles) {
            if (!isClosed) {
                ++count
            } else {
                --count
            }
            result = maxOf(result, count)
        }
        return result
    }
}
