package convexpolygon

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isConvex(points: Array<IntArray>): Boolean {
        val n = points.size
        var prev = 0L
        for (i in 0 until n) {
            val ax = points[(i + 1) % n][0] - points[i][0]
            val ay = points[(i + 1) % n][1] - points[i][1]
            val bx = points[(i + 2) % n][0] - points[i][0]
            val by = points[(i + 2) % n][1] - points[i][1]
            val curr = (ax * by - ay * bx).toLong()
            if (curr != 0L) {
                if (curr * prev < 0) {
                    return false
                }
                prev = curr
            }
        }
        return true
    }
}
