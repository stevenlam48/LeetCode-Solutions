package minimumtimeforkvirusvariantstospread

// Time:  O(nlogn * logr), r is the sum of range x size and range y size
// Space: O(n)

class Solution {
    fun minDayskVariants(points: Array<IntArray>, k: Int): Int {
        val rotated = Array(points.size) { intArrayOf(points[it][0] + points[it][1], points[it][0] - points[it][1]) }
        val minX = rotated.minOf { it[0] }
        val maxX = rotated.maxOf { it[0] }
        val minY = rotated.minOf { it[1] }
        val maxY = rotated.maxOf { it[1] }
        var left = 0L
        var right = ((maxX.toLong() - minX) + (maxY.toLong() - minY) + 1) / 2
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(rotated, k, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left.toInt()
    }

    private fun check(points: Array<IntArray>, k: Int, l: Long): Boolean {
        val intervals = ArrayList<LongArray>(points.size * 2)
        val ySet = HashSet<Long>()
        for (p in points) {
            val x0 = p[0].toLong() - l
            val y0 = p[1].toLong() - l
            val x1 = p[0].toLong() + l
            val y1 = p[1].toLong() + l
            intervals.add(longArrayOf(x0, 1L, y0, y1))
            intervals.add(longArrayOf(x1 + 1, -1L, y0, y1))
            ySet.add(y0)
            ySet.add(y1)
        }
        intervals.sortWith(compareBy({ it[0] }, { it[1] }, { it[2] }, { it[3] }))
        val sortedY = ySet.toLongArray()
        sortedY.sort()
        val yToIdx = HashMap<Long, Int>(sortedY.size * 2)
        for (i in sortedY.indices) {
            yToIdx[sortedY[i]] = i
        }
        val st = SegmentTree(yToIdx.size)
        for (e in intervals) {
            st.update(yToIdx[e[2]]!!, yToIdx[e[3]]!!, e[1].toInt())
            if (st.query(0, yToIdx.size - 1) >= k) {
                return true
            }
        }
        return false
    }

    private class SegmentTree(n: Int) {
        private val size = n
        private var height = 1
        private val tree = IntArray(2 * n)
        private val lazy = IntArray(n)

        init {
            while ((1 shl height) < n) {
                ++height
            }
        }

        fun update(l0: Int, r0: Int, h: Int) {
            var l = l0 + size
            var r = r0 + size
            val lStart = l
            val rStart = r
            while (l <= r) {
                if ((l and 1) == 1) {
                    apply(l++, h)
                }
                if ((r and 1) == 0) {
                    apply(r--, h)
                }
                l = l shr 1
                r = r shr 1
            }
            pull(lStart)
            pull(rStart)
        }

        fun query(l0: Int, r0: Int): Int {
            var l = l0 + size
            var r = r0 + size
            var result = 0
            push(l)
            push(r)
            while (l <= r) {
                if ((l and 1) == 1) {
                    result = maxOf(result, tree[l])
                    ++l
                }
                if ((r and 1) == 0) {
                    result = maxOf(result, tree[r])
                    --r
                }
                l = l shr 1
                r = r shr 1
            }
            return result
        }

        private fun apply(x: Int, value: Int) {
            tree[x] += value
            if (x < size) {
                lazy[x] += value
            }
        }

        private fun pull(x0: Int) {
            var x = x0
            while (x > 1) {
                x = x shr 1
                tree[x] = maxOf(tree[x * 2], tree[x * 2 + 1])
                if (lazy[x] != 0) {
                    tree[x] += lazy[x]
                }
            }
        }

        private fun push(x0: Int) {
            val x = x0
            for (h in height downTo 1) {
                val y = x shr h
                if (lazy[y] != 0) {
                    apply(y * 2, lazy[y])
                    apply(y * 2 + 1, lazy[y])
                    lazy[y] = 0
                }
            }
        }
    }
}
