package numberofislands
// Time:  O(m * n * α(n)) ~= O(m * n)
// Space: O(m * n)

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        var zeroCount = 0
        val unionFind = UnionFind(grid.size * grid[0].size)
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == '1') {
                    if (i != 0 && grid[i][j] == grid[i - 1][j]) {
                        unionFind.unionSet(index(grid[0].size, i - 1, j), index(grid[0].size, i, j))
                    }
                    if (j != 0 && grid[i][j] == grid[i][j - 1]) {
                        unionFind.unionSet(index(grid[0].size, i, j - 1), index(grid[0].size, i, j))
                    }
                } else {
                    ++zeroCount
                }
            }
        }
        return unionFind.size() - zeroCount
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

    private fun index(n: Int, i: Int, j: Int): Int = i * n + j
}
