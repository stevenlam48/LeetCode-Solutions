package minimumpartitionscoreii
// Time:  O(n * log(n * r)) = O(nlogn + nlogr), r = max(nums)
// Space: O(n)

class Solution {
    private data class Line(val slope: Long, val intercept: Long, val count: Int)

    fun minPartitionScore(nums: IntArray, k: Int): Long {
        fun check(l1: Line, l2: Line, l3: Line): Boolean {
            return (l2.intercept - l1.intercept) * (l2.slope - l3.slope) <
                (l3.intercept - l2.intercept) * (l1.slope - l2.slope)
        }

        val prefix = LongArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }

        fun maxLambda(): Long {
            var mx = 0L
            val total = prefix.last() * (prefix.last() + 1) / 2
            for (i in 1 until nums.size) {
                val c1 = prefix[i]
                val c2 = prefix.last() - prefix[i]
                mx = maxOf(mx, total - (c1 * (c1 + 1) / 2 + c2 * (c2 + 1) / 2))
            }
            return mx
        }

        fun f(l: Long): Pair<Long, Int> {
            var dp = 0L
            var cnt = 0
            val hull = ArrayDeque<Line>()
            hull.add(Line(0L, 0L, 0))
            for (i in nums.indices) {
                val x = prefix[i + 1]
                while (hull.size >= 2 &&
                    hull[0].slope * x + hull[0].intercept > hull[1].slope * x + hull[1].intercept
                ) {
                    hull.removeFirst()
                }
                dp = hull[0].slope * x + hull[0].intercept + (x * x + x) / 2 + l
                cnt = hull[0].count + 1
                val line = Line(-x, dp + (x * x - x) / 2, cnt)
                while (hull.size >= 2 && !check(hull[hull.size - 2], hull.last(), line)) {
                    hull.removeLast()
                }
                hull.add(line)
            }
            return dp to cnt
        }

        fun binarySearch(leftBound: Long, rightBound: Long, predicate: (Long) -> Boolean): Long {
            var left = leftBound
            var right = rightBound
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (predicate(mid)) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return left
        }

        val mx = maxLambda()
        assert(f(mx).second == 1)
        val l = binarySearch(0L, mx) { f(it).second <= k }
        return f(l).first - k * l
    }
}
