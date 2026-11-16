package findthesafestpathinagrid

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun maximumSafenessFactor(grid: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(-1, 0),
            intArrayOf(0, -1)
        )

        fun bfs(): Array<IntArray> {
            val dist = Array(grid.size) { IntArray(grid[0].size) { -1 } }
            var q = mutableListOf<Pair<Int, Int>>()
            for (r in grid.indices) {
                for (c in grid[0].indices) {
                    if (grid[r][c] != 0) {
                        dist[r][c] = 0
                        q.add(r to c)
                    }
                }
            }
            var d = 0
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Pair<Int, Int>>()
                for ((r, c) in q) {
                    for (direction in directions) {
                        val nr = r + direction[0]
                        val nc = c + direction[1]
                        if (nr !in dist.indices || nc !in dist[0].indices || dist[nr][nc] != -1) {
                            continue
                        }
                        dist[nr][nc] = d + 1
                        newQ.add(nr to nc)
                    }
                }
                q = newQ
                ++d
            }
            return dist
        }

        val dist = bfs()
        val buckets = Array(grid.lastIndex + grid[0].lastIndex + 1) {
            mutableListOf<Pair<Int, Int>>()
        }
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                buckets[dist[r][c]].add(r to c)
            }
        }
        val lookup = Array(grid.size) { BooleanArray(grid[0].size) }
        val uf = UnionFind(grid.size * grid[0].size)
        var d = buckets.lastIndex
        while (d >= 0) {
            for ((r, c) in buckets[d]) {
                for (direction in directions) {
                    val nr = r + direction[0]
                    val nc = c + direction[1]
                    if (nr !in dist.indices || nc !in dist[0].indices || !lookup[nr][nc]) {
                        continue
                    }
                    uf.unionSet(nr * grid[0].size + nc, r * grid[0].size + c)
                }
                lookup[r][c] = true
            }
            if (uf.findSet(0) == uf.findSet(grid.lastIndex * grid[0].size + grid[0].lastIndex)) {
                break
            }
            --d
        }
        return d
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            var xRoot = findSet(x)
            var yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            if (rank[xRoot] > rank[yRoot]) {
                val temp = xRoot
                xRoot = yRoot
                yRoot = temp
            }
            set[xRoot] = yRoot
            if (rank[xRoot] == rank[yRoot]) {
                ++rank[yRoot]
            }
            return true
        }
    }
}
