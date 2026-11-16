package maximizethedistancebetweenpointsonasquare

// Time:  O(nlogn + nlogs), s = side
// Space: O(n)

class Solution {
    fun maxDistance(side: Int, points: Array<IntArray>, k: Int): Int {
        fun binarySearchRight(left0: Long, right0: Long, check: (Long) -> Boolean): Long {
            var left = left0
            var right = right0
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

        val p = LongArray(points.size)
        for (idx in points.indices) {
            val x = points[idx]
            p[idx] = when {
                x[0] == 0 -> x[1].toLong()
                x[1] == side -> side.toLong() + x[0]
                x[0] == side -> 2L * side + (side - x[1])
                else -> 3L * side + (side - x[0])
            }
        }
        p.sort()

        fun check(d: Long): Boolean {
            val intervals = mutableListOf<Triple<Int, Int, Int>>()
            intervals.add(Triple(0, 0, 1))
            var i = 0
            for (right in 1 until p.size) {
                var left = right
                var cnt = 1
                while (i < intervals.size) {
                    val (l, r, c) = intervals[i]
                    if (p[right] - p[r] < d) {
                        break
                    }
                    if (p[l] + 4L * side - p[right] >= d) {
                        if (c + 1 >= cnt) {
                            cnt = c + 1
                            left = l
                        }
                    }
                    ++i
                }
                intervals.add(Triple(left, right, cnt))
            }
            var mx = 0
            for ((_, _, c) in intervals) {
                mx = maxOf(mx, c)
            }
            return mx >= k
        }

        return binarySearchRight(1L, 4L * side / k, ::check).toInt()
    }
}
