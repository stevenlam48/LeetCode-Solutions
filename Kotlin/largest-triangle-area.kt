package largesttrianglearea

import kotlin.math.abs

// Time:  O(n^3)
// Space: O(1)

class Solution {
    fun largestTriangleArea(points: Array<IntArray>): Double {
        var result = 0.0
        for (i in 0 until points.size - 2) {
            for (j in i + 1 until points.size - 1) {
                for (k in j + 1 until points.size) {
                    result = maxOf(
                        result,
                        0.5 * abs(
                            points[i][0] * points[j][1] +
                                points[j][0] * points[k][1] +
                                points[k][0] * points[i][1] -
                                points[j][0] * points[i][1] -
                                points[k][0] * points[j][1] -
                                points[i][0] * points[k][1]
                        )
                    )
                }
            }
        }
        return result
    }
}
