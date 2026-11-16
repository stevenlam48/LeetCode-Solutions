package separatesquaresii

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun separateSquares(squares: Array<IntArray>): Double {
        val events = ArrayList<IntArray>()
        val xSet = HashSet<Int>()
        for (s in squares) {
            events.add(intArrayOf(s[1], 1, s[0], s[0] + s[2]))
            events.add(intArrayOf(s[1] + s[2], -1, s[0], s[0] + s[2]))
            xSet.add(s[0])
            xSet.add(s[0] + s[2])
        }
        events.sortBy { it[0] }
        val sortedX = xSet.toIntArray()
        sortedX.sort()
        val xToIdx = HashMap<Int, Int>()
        for (i in sortedX.indices) {
            xToIdx[sortedX[i]] = i
        }
        val st = SegmentTreeRecu(sortedX)
        var prev = events[0][0]
        val intervals = ArrayList<Triple<Int, Int, Double>>()
        for (e in events) {
            val y = e[0]
            val v = e[1]
            val x1 = e[2]
            val x2 = e[3]
            if (y != prev) {
                intervals.add(Triple(prev, y, st.tree[1].toDouble()))
                prev = y
            }
            st.update(xToIdx[x1]!!, xToIdx[x2]!!, v, 0, sortedX.size - 1, 1)
        }
        var expect = 0.0
        for ((y1, y2, curr) in intervals) {
            expect += (y2 - y1) * curr
        }
        expect /= 2
        var total = 0.0
        for ((y1, y2, curr) in intervals) {
            if (total + (y2 - y1) * curr >= expect) {
                return y1 + (expect - total) / curr
            }
            total += (y2 - y1) * curr
        }
        return -1.0
    }

    private class SegmentTreeRecu(private val sortedX: IntArray) {
        val tree: IntArray
        private val cnt: IntArray

        init {
            val n = sortedX.size - 1
            val l = if (n > 1) 1 shl (31 - Integer.numberOfLeadingZeros(n - 1) + 2) else 2
            tree = IntArray(l)
            cnt = IntArray(l)
        }

        fun update(ql: Int, qr: Int, v: Int, l: Int, r: Int, i: Int) {
            if (ql >= r || qr <= l) {
                return
            }
            if (ql <= l && r <= qr) {
                cnt[i] += v
            } else {
                val m = l + (r - l) / 2
                update(ql, qr, v, l, m, 2 * i)
                update(ql, qr, v, m, r, 2 * i + 1)
            }
            if (cnt[i] > 0) {
                tree[i] = sortedX[r] - sortedX[l]
            } else {
                if (r - l == 1) {
                    tree[i] = 0
                } else {
                    tree[i] = tree[2 * i] + tree[2 * i + 1]
                }
            }
        }
    }
}
