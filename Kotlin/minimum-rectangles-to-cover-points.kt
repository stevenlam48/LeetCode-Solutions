package minimumrectanglestocoverpoints

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
        points.sortWith(compareBy<IntArray> { it[0] })
        var result = 0
        var left = -(w + 1)
        for (p in points) {
            if (p[0] - left <= w) {
                continue
            }
            left = p[0]
            ++result
        }
        return result
    }
}
