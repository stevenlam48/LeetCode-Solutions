package lastdaywhereyoucanstillcross

// Time:  O(m * n *  α(c)) = O(m * n)
// Space: O(m * n)

class Solution {
    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        val start = row * col
        val end = row * col + 1
        val uf = UnionFind(row * col + 2)
        val lookup = Array(row) { BooleanArray(col) }
        for (i in cells.indices.reversed()) {
            val r = cells[i][0] - 1
            val c = cells[i][1] - 1
            for ((dr, dc) in directions) {
                val nr = r + dr
                val nc = c + dc
                if (!(nr in 0 until row && nc in 0 until col && lookup[nr][nc])) {
                    continue
                }
                uf.unionSet(index(col, r, c), index(col, nr, nc))
            }
            if (r == 0) {
                uf.unionSet(start, index(col, r, c))
            }
            if (r == row - 1) {
                uf.unionSet(end, index(col, r, c))
            }
            if (uf.findSet(start) == uf.findSet(end)) {
                return i
            }
            lookup[r][c] = true
        }
        return -1
    }

    private fun index(n: Int, i: Int, j: Int): Int = i * n + j

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private var count = n

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            if (rank[xRoot] < rank[yRoot]) {
                set[xRoot] = yRoot
            } else if (rank[xRoot] > rank[yRoot]) {
                set[yRoot] = xRoot
            } else {
                set[yRoot] = xRoot
                ++rank[xRoot]
            }
            --count
            return true
        }

        fun size(): Int = count
    }
}
