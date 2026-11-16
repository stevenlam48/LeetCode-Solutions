package regionscutbyslashes
// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun regionsBySlashes(grid: List<String>): Int {
        val unionFind = UnionFind(grid.size * grid.size * 4)
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (i != 0) {
                    unionFind.unionSet(index(grid.size, i - 1, j, S), index(grid.size, i, j, N))
                }
                if (j != 0) {
                    unionFind.unionSet(index(grid.size, i, j - 1, E), index(grid.size, i, j, W))
                }
                if (grid[i][j] != '/') {
                    unionFind.unionSet(index(grid.size, i, j, N), index(grid.size, i, j, E))
                    unionFind.unionSet(index(grid.size, i, j, S), index(grid.size, i, j, W))
                }
                if (grid[i][j] != '\\') {
                    unionFind.unionSet(index(grid.size, i, j, W), index(grid.size, i, j, N))
                    unionFind.unionSet(index(grid.size, i, j, E), index(grid.size, i, j, S))
                }
            }
        }
        return unionFind.size()
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private var count = n

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int) {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot != yRoot) {
                set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
                --count
            }
        }

        fun size(): Int = count
    }

    private fun index(n: Int, i: Int, j: Int, k: Int): Int = (i * n + j) * 4 + k

    private companion object {
        const val N = 0
        const val E = 1
        const val S = 2
        const val W = 3
    }
}
