package minimumcosttodividearrayintosubarrays
// Time:  O(nlogn)
// Space: O(n)

import java.util.TreeSet

class Solution {
    fun minimumCost(nums: IntArray, cost: IntArray, k: Int): Long {
        val prefix1 = LongArray(nums.size + 1)
        val prefix2 = LongArray(nums.size + 1)
        for (i in nums.indices) {
            prefix1[i + 1] = prefix1[i] + nums[i]
            prefix2[i + 1] = prefix2[i] + cost[i]
        }
        var dp = 0L
        val lc = LineContainer()
        for (i in nums.indices.reversed()) {
            lc.add(prefix1[i + 1], -(dp + prefix1[i + 1] * prefix2[i + 1]))
            dp = -lc.query(prefix2[i]) + k * (prefix2.last() - prefix2[i])
        }
        return dp
    }

    private class Line(val k: Long, val m: Long, val order: Int, var p: Long = 0)
    private class Query(val x: Long)

    private class LineContainer {
        private val inf = Long.MAX_VALUE
        private var nextOrder = 0
        private val lines = TreeSet<Any>(Comparator { a, b ->
            when {
                a is Line && b is Line -> compareValuesBy(a, b, { it.k }, { it.order })
                a is Line && b is Query -> a.p.compareTo(b.x)
                a is Query && b is Line -> a.x.compareTo(b.p)
                else -> 0
            }
        })

        private fun div(a: Long, b: Long): Long {
            return a / b - if ((a xor b) < 0 && a % b != 0L) 1 else 0
        }

        private fun isect(x: Line, y: Line?): Boolean {
            if (y == null) {
                x.p = inf
                return false
            }
            if (x.k == y.k) {
                x.p = if (x.m > y.m) inf else -inf
            } else {
                x.p = div(y.m - x.m, x.k - y.k)
            }
            return x.p >= y.p
        }

        fun add(k: Long, m: Long) {
            val added = Line(k, m, nextOrder++)
            lines.add(added)
            var z = lines.higher(added) as Line?
            while (isect(added, z)) {
                lines.remove(z!!)
                z = lines.higher(added) as Line?
            }
            var x = lines.lower(added) as Line?
            if (x != null && isect(x, added)) {
                val next = lines.higher(added) as Line?
                lines.remove(added)
                isect(x, next)
            }
            while (x != null) {
                val y = x
                x = lines.lower(y) as Line? ?: break
                if (x.p < y.p) {
                    break
                }
                val next = lines.higher(y) as Line?
                lines.remove(y)
                isect(x, next)
            }
        }

        fun query(x: Long): Long {
            val line = lines.ceiling(Query(x)) as Line
            return line.k * x + line.m
        }
    }
}
