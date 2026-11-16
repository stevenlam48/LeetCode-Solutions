package swiminrisingwater
// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val positions = arrayOfNulls<Pair<Int, Int>>(n * n)
        for (i in 0 until n) {
            for (j in 0 until n) {
                positions[grid[i][j]] = Pair(i, j)
            }
        }
        val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
        val unionFind = UnionFind(n * n)
        for (elevation in positions.indices) {
            val (i, j) = positions[elevation]!!
            for ((di, dj) in directions) {
                val x = i + di
                val y = j + dj
                if (x in 0 until n && y in 0 until n && grid[x][y] <= elevation) {
                    unionFind.unionSet(i * n + j, x * n + y)
                    if (unionFind.findSet(0) == unionFind.findSet(n * n - 1)) {
                        return elevation
                    }
                }
            }
        }
        return n * n - 1
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }

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
            }
        }
    }
}
