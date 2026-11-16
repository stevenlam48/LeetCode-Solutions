package bricksfallingwhenhit

// Time:  O(r * c)
// Space: O(r * c)

class Solution {
    fun hitBricks(grid: Array<IntArray>, hits: Array<IntArray>): IntArray {
        val directions = arrayOf(
            intArrayOf(-1, 0), intArrayOf(1, 0),
            intArrayOf(0, 1), intArrayOf(0, -1)
        )
        val R = grid.size
        val C = grid[0].size
        fun index(r: Int, c: Int) = r * C + c

        val hitGrid = Array(R) { grid[it].copyOf() }
        for (hit in hits) {
            hitGrid[hit[0]][hit[1]] = 0
        }

        val unionFind = UnionFind(R * C)
        for (r in 0 until R) {
            for (c in 0 until C) {
                if (hitGrid[r][c] == 0) {
                    continue
                }
                if (r == 0) {
                    unionFind.unionSet(index(r, c), R * C)
                }
                if (r > 0 && hitGrid[r - 1][c] != 0) {
                    unionFind.unionSet(index(r, c), index(r - 1, c))
                }
                if (c > 0 && hitGrid[r][c - 1] != 0) {
                    unionFind.unionSet(index(r, c), index(r, c - 1))
                }
            }
        }

        val result = mutableListOf<Int>()
        for (i in hits.size - 1 downTo 0) {
            val r = hits[i][0]
            val c = hits[i][1]
            val prevRoof = unionFind.top()
            if (grid[r][c] == 0) {
                result.add(0)
                continue
            }
            for (d in directions) {
                val nr = r + d[0]
                val nc = c + d[1]
                if (nr in 0 until R && nc in 0 until C && hitGrid[nr][nc] != 0) {
                    unionFind.unionSet(index(r, c), index(nr, nc))
                }
            }
            if (r == 0) {
                unionFind.unionSet(index(r, c), R * C)
            }
            hitGrid[r][c] = 1
            result.add(maxOf(0, unionFind.top() - prevRoof - 1))
        }
        result.reverse()
        return result.toIntArray()
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n + 1) { it }
        private val size = IntArray(n + 1) { 1 }

        init {
            size[n] = 0
        }

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
            set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            size[maxOf(xRoot, yRoot)] += size[minOf(xRoot, yRoot)]
            return true
        }

        fun top(): Int = size[findSet(size.size - 1)]
    }
}
