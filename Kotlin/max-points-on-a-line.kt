package maxpointsonaline

// Time:  O(n^2)
// Space: O(n)

class Point(var x: Int = 0, var y: Int = 0)

class Solution {
    fun maxPoints(points: Array<Point>): Int {
        var maxPoints = 0
        for (i in points.indices) {
            val slopeCount = HashMap<Double, Int>()
            val start = points[i]
            var same = 1
            for (j in i + 1 until points.size) {
                val end = points[j]
                if (start.x == end.x && start.y == end.y) {
                    same++
                } else {
                    var slope = Double.MAX_VALUE
                    if (start.x - end.x != 0) {
                        slope = (start.y - end.y).toDouble() / (start.x - end.x)
                    }
                    slopeCount[slope] = (slopeCount[slope] ?: 0) + 1
                }
            }
            var currentMax = same
            for (count in slopeCount.values) {
                currentMax = maxOf(currentMax, count + same)
            }
            maxPoints = maxOf(maxPoints, currentMax)
        }
        return maxPoints
    }
}
