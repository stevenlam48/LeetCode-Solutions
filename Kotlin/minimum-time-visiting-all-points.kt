package minimumtimevisitingallpoints

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var result = 0
        for (i in 0 until points.size - 1) {
            result += maxOf(
                abs(points[i + 1][1] - points[i][1]),
                abs(points[i + 1][0] - points[i][0])
            )
        }
        return result
    }
}
