package minimumnumberofarrowstoburstballoons
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.isEmpty()) {
            return 0
        }

        points.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

        var result = 0
        var i = 0
        while (i < points.size) {
            var j = i + 1
            var rightBound = points[i][1]
            while (j < points.size && points[j][0] <= rightBound) {
                rightBound = minOf(rightBound, points[j][1])
                ++j
            }
            ++result
            i = j
        }
        return result
    }
}
