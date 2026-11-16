package largestlocalvaluesinamatrixii

// Time:  O(n * m * logn * logm)
// Space: O(n * m * logn * logm)

class Solution {
    fun countLocalMaximums(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size
        val st = SparseTable2D(matrix) { x, y -> if (x < y) y else x }
        var result = 0
        for (r in 0 until n) {
            val row = matrix[r]
            for (c in 0 until m) {
                val x = row[c]
                if (x == 0) {
                    continue
                }
                val r1 = maxOf(r - x, 0)
                val r2 = minOf(r + x, n - 1)
                val c1 = maxOf(c - x, 0)
                val c2 = minOf(c + x, m - 1)
                val tl = r - x >= 0 && c - x >= 0
                val tr = r - x >= 0 && c + x <= m - 1
                val bl = r + x <= n - 1 && c - x >= 0
                val br = r + x <= n - 1 && c + x <= m - 1
                if (maxOf(
                        st.query(r1, c1 + if (tl || bl) 1 else 0, r2, c2 - if (tr || br) 1 else 0),
                        st.query(r1 + if (tl || tr) 1 else 0, c1, r2 - if (bl || br) 1 else 0, c2)
                    ) <= x
                ) {
                    ++result
                }
            }
        }
        return result
    }

    private class SparseTable2D(matrix: Array<IntArray>, private val fn: (Int, Int) -> Int) {
        private val st: Array<Array<Array<IntArray>>>

        init {
            val n = matrix.size
            val m = matrix[0].size
            val logn = 31 - n.countLeadingZeroBits()
            val logm = 31 - m.countLeadingZeroBits()
            st = Array(logn + 1) { Array(logm + 1) { Array(n) { IntArray(m) } } }
            for (r in 0 until n) {
                for (c in 0 until m) {
                    st[0][0][r][c] = matrix[r][c]
                }
            }
            for (j in 1..logm) {
                for (r in 0 until n) {
                    for (c in 0..m - (1 shl j)) {
                        st[0][j][r][c] = fn(st[0][j - 1][r][c], st[0][j - 1][r][c + (1 shl (j - 1))])
                    }
                }
            }
            for (i in 1..logn) {
                for (j in 0..logm) {
                    for (r in 0..n - (1 shl i)) {
                        for (c in 0..m - (1 shl j)) {
                            st[i][j][r][c] = fn(st[i - 1][j][r][c], st[i - 1][j][r + (1 shl (i - 1))][c])
                        }
                    }
                }
            }
        }

        fun query(r1: Int, c1: Int, r2: Int, c2: Int): Int {
            val i = 31 - (r2 - r1 + 1).countLeadingZeroBits()
            val j = 31 - (c2 - c1 + 1).countLeadingZeroBits()
            return fn(
                fn(st[i][j][r1][c1], st[i][j][r1][c2 - (1 shl j) + 1]),
                fn(st[i][j][r2 - (1 shl i) + 1][c1], st[i][j][r2 - (1 shl i) + 1][c2 - (1 shl j) + 1])
            )
        }
    }
}
