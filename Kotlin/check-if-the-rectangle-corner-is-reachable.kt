package checkiftherectanglecornerisreachable

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun canReachCorner(X: Int, Y: Int, circles: Array<IntArray>): Boolean {
        fun check(x1: Long, y1: Long, r1: Long, x2: Long, y2: Long, r2: Long): Boolean {
            return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= (r1 + r2) * (r1 + r2)
        }

        val lookup = BooleanArray(circles.size)
        val dst = BooleanArray(circles.size)
        val stk = ArrayDeque<Int>()
        for (u in circles.indices) {
            val x = circles[u][0]
            val y = circles[u][1]
            val r = circles[u][2]
            if (x - r <= 0 || y + r >= Y) {
                lookup[u] = true
                stk.addLast(u)
            }
            if (x + r >= X || y - r <= 0) {
                dst[u] = true
            }
        }
        while (stk.isNotEmpty()) {
            val u = stk.removeLast()
            if (dst[u]) {
                return false
            }
            val x1 = circles[u][0].toLong()
            val y1 = circles[u][1].toLong()
            val r1 = circles[u][2].toLong()
            for (v in circles.indices) {
                val x2 = circles[v][0].toLong()
                val y2 = circles[v][1].toLong()
                val r2 = circles[v][2].toLong()
                if (lookup[v] || !check(x1, y1, r1, x2, y2, r2)) {
                    continue
                }
                lookup[v] = true
                stk.addLast(v)
            }
        }
        return true
    }
}
