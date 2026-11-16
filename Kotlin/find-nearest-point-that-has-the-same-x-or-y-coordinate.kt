package findnearestpointthathasthesamexorycoordinate

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        var smallest = Int.MAX_VALUE
        var idx = -1
        for (i in points.indices) {
            val dx = x - points[i][0]
            val dy = y - points[i][1]
            if (dx * dy == 0 && abs(dx) + abs(dy) < smallest) {
                smallest = abs(dx) + abs(dy)
                idx = i
            }
        }
        return idx
    }
}
