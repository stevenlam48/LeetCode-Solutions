package maximizetheminimumgamescore

// Time:  O(n * log(m * r))
// Space: O(1)

class Solution {
    fun maxScore(points: IntArray, m: Int): Long {
        fun ceilDivide(a: Long, b: Long): Long = (a + b - 1) / b

        fun check(x: Long): Boolean {
            var prev = 0L
            var cnt = 0L
            for (i in points.indices) {
                val remain = ceilDivide(x, points[i].toLong()) - prev
                if (remain >= 1) {
                    prev = remain - 1
                    cnt += 2 * remain - 1
                } else if (i != points.size - 1) {
                    prev = 0
                    ++cnt
                }
                if (cnt > m) {
                    return false
                }
            }
            return true
        }

        var left = 1L
        var right = points.max().toLong() * m
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }
}
