package minimumtimetocompletealldeliveries

// Time:  O(logr + logd)
// Space: O(1)

class Solution {
    fun minimumTime(d: IntArray, r: IntArray): Long {
        val l = lcm(r[0], r[1])

        fun check(t: Long): Boolean {
            return t - t / r[0] >= d[0] && t - t / r[1] >= d[1] && t - t / l >= d[0] + d[1]
        }

        var left = (d[0] + d[1]).toLong()
        var right = 2L * (d[0] + d[1])
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a else gcd(b, a % b)
    }

    private fun lcm(a: Int, b: Int): Long {
        val x = a.toLong()
        val y = b.toLong()
        return x / gcd(x, y) * y
    }
}
