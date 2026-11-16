package bookingconcertticketsingroups

// Time:  ctor:    O(n)
//        gather:  O(logn)
//        scatter: O(logn), amortized
// Space: O(n)

// design, segment tree, binary search, optimized from bookmyshow2
class BookMyShow(n: Int, private val m: Int) {
    private val st = SegmentTree(n, m)
    private var i = 0

    fun gather(k: Int, maxRow: Int): IntArray {
        var idx = 1
        if (k > st.tree[idx][0]) {
            return IntArray(0)
        }
        while (idx < st.base) {
            idx = 2 * idx + if (st.tree[2 * idx][0] < k) 1 else 0
        }
        if (idx - st.base > maxRow) {
            return IntArray(0)
        }
        val cnt = st.tree[idx][0].toInt()
        val c = m - cnt
        idx -= st.base
        st.update(idx, longArrayOf((cnt - k).toLong(), (cnt - k).toLong()))
        return intArrayOf(idx, c)
    }

    fun scatter(k0: Int, maxRow: Int): Boolean {
        var k = k0
        if (k.toLong() > st.query(i, maxRow)) {
            return false
        }
        var idx = i
        while (idx <= maxRow && k > 0) {
            var cnt = st.tree[st.base + idx][1].toInt()
            val c = minOf(cnt, k)
            cnt -= c
            if (cnt == 0) {
                ++i
            }
            st.update(idx, longArrayOf(cnt.toLong(), cnt.toLong()))
            k -= c
            ++idx
        }
        return true
    }

    private class SegmentTree(N: Int, m: Int) {
        val tree: Array<LongArray>
        val base: Int

        init {
            base = if (N > 1) 1 shl (lg(N - 1) + 1) else 1
            tree = Array(if (N > 1) 1 shl (lg(N - 1) + 2) else 2) { LongArray(2) }
            for (j in base until base + N) {
                tree[j][0] = m.toLong()
                tree[j][1] = m.toLong()
            }
            for (j in base - 1 downTo 1) {
                tree[j][0] = maxOf(tree[j * 2][0], tree[j * 2 + 1][0])
                tree[j][1] = tree[j * 2][1] + tree[j * 2 + 1][1]
            }
        }

        fun update(i: Int, h: LongArray) {
            var x = base + i
            tree[x] = h
            while (x > 1) {
                x /= 2
                tree[x][0] = maxOf(tree[x * 2][0], tree[x * 2 + 1][0])
                tree[x][1] = tree[x * 2][1] + tree[x * 2 + 1][1]
            }
        }

        fun query(L0: Int, R0: Int): Long {
            var L = L0 + base
            var R = R0 + base
            var result = 0L
            while (L <= R) {
                if (L and 1 == 1) {
                    result += tree[L][1]
                    ++L
                }
                if (R and 1 == 0) {
                    result += tree[R][1]
                    --R
                }
                L /= 2
                R /= 2
            }
            return result
        }

        private fun lg(x: Int): Int = 31 - Integer.numberOfLeadingZeros(x)
    }
}
