package amountofnewareapaintedeachday

// Time:  O(nlogr), r is the max position
// Space: O(r)

class SegmentTree(N: Int) {
    private val base: Int = N
    private var h: Int = 1
    private val tree = IntArray(2 * N)
    private val lazy = IntArray(2 * N)
    private val count = IntArray(2 * N) { 1 }

    init {
        while ((1 shl h) < N) {
            ++h
        }
        for (i in N - 1 downTo 1) {
            count[i] = count[2 * i] + count[2 * i + 1]
        }
    }

    fun update(L: Int, R: Int, value: Int) {
        var l = L + base
        var r = R + base
        push(l)
        push(r)
        val l0 = l
        val r0 = r
        while (l <= r) {
            if ((l and 1) == 1) {
                apply(l++, value)
            }
            if ((r and 1) == 0) {
                apply(r--, value)
            }
            l = l shr 1
            r = r shr 1
        }
        pull(l0)
        pull(r0)
    }

    fun query(L: Int, R: Int): Int {
        var result = 0
        if (L > R) {
            return result
        }
        var l = L + base
        var r = R + base
        push(l)
        push(r)
        while (l <= r) {
            if ((l and 1) == 1) {
                result += tree[l++]
            }
            if ((r and 1) == 0) {
                result += tree[r--]
            }
            l = l shr 1
            r = r shr 1
        }
        return result
    }

    private fun apply(x: Int, value: Int) {
        tree[x] = value * count[x]
        if (x < base) {
            lazy[x] = value
        }
    }

    private fun pull(x0: Int) {
        var x = x0
        while (x > 1) {
            x = x shr 1
            tree[x] = tree[x * 2] + tree[x * 2 + 1]
            if (lazy[x] != 0) {
                tree[x] = lazy[x] * count[x]
            }
        }
    }

    private fun push(x: Int) {
        for (level in h downTo 1) {
            val y = x shr level
            if (lazy[y] != 0) {
                apply(y * 2, lazy[y])
                apply(y * 2 + 1, lazy[y])
                lazy[y] = 0
            }
        }
    }
}

// segment tree
class Solution {
    fun amountPainted(paint: Array<IntArray>): IntArray {
        val maxPos = paint.maxOf { it[1] }
        val st = SegmentTree(maxPos)
        val result = IntArray(paint.size)
        for (idx in paint.indices) {
            val x = paint[idx]
            val cnt = st.query(x[0], x[1] - 1)
            st.update(x[0], x[1] - 1, 1)
            result[idx] = st.query(x[0], x[1] - 1) - cnt
        }
        return result
    }
}
