package minimumnumberofvisitedcellsinagrid

// Time:  O(m * n * alpha(m + n)) = O(m + n)
// Space: O(m * n)

// bfs, union find
class Solution {
    fun minimumVisitedCells(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val uf1 = Array(m) { UnionFind(n + 1) }
        val uf2 = Array(n) { UnionFind(m + 1) }
        var d = 1
        var q = listOf(intArrayOf(0, 0))
        uf1[0].unionSet(0, 1)
        uf2[0].unionSet(0, 1)
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<IntArray>()
            for (p in q) {
                val i = p[0]
                val j = p[1]
                if (i == m - 1 && j == n - 1) {
                    return d
                }
                while (uf1[i].rightSet(j) <= minOf(j + grid[i][j], n - 1)) {
                    val k = uf1[i].rightSet(j)
                    newQ.add(intArrayOf(i, k))
                    uf2[k].unionSet(i, i + 1)
                    uf1[i].unionSet(k, k + 1)
                }
                while (uf2[j].rightSet(i) <= minOf(i + grid[i][j], m - 1)) {
                    val k = uf2[j].rightSet(i)
                    newQ.add(intArrayOf(k, j))
                    uf1[k].unionSet(j, j + 1)
                    uf2[j].unionSet(k, k + 1)
                }
            }
            q = newQ
            ++d
        }
        return -1
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private val right = IntArray(n) { it }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x0: Int, y0: Int): Boolean {
            var x = findSet(x0)
            var y = findSet(y0)
            if (x == y) {
                return false
            }
            if (rank[x] > rank[y]) {
                val tmp = x
                x = y
                y = tmp
            }
            set[x] = y
            if (rank[x] == rank[y]) {
                ++rank[y]
            }
            right[y] = maxOf(right[x], right[y])
            return true
        }

        fun rightSet(x: Int): Int {
            return right[findSet(x)]
        }
    }
}
