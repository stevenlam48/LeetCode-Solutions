package minimummovestospreadstonesovergrid

// Time:  O(max(x^2 * y)) = O(n^3), n = len(grid)*len(grid[0]), y = len(zero), x = n-y
// Space: O(max(x^2)) = O(n^2)

import kotlin.math.abs

class Solution {
    fun minimumMoves(grid: Array<IntArray>): Int {
        val src = mutableListOf<Pair<Int, Int>>()
        val dst = mutableListOf<Pair<Int, Int>>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] - 1 >= 0) {
                    repeat(grid[i][j] - 1) {
                        src.add(i to j)
                    }
                } else {
                    dst.add(i to j)
                }
            }
        }
        val adj = Array(src.size) { i ->
            IntArray(dst.size) { j ->
                abs(src[i].first - dst[j].first) + abs(src[i].second - dst[j].second)
            }
        }
        return hungarian(adj).first
    }

    private fun hungarian(a: Array<IntArray>): Pair<Int, IntArray> {
        if (a.isEmpty()) {
            return 0 to intArrayOf()
        }
        val n = a.size + 1
        val m = a[0].size + 1
        val u = IntArray(n)
        val v = IntArray(m)
        val p = IntArray(m)
        val ans = IntArray(n - 1)
        for (i in 1 until n) {
            p[0] = i
            var j0 = 0
            val dist = IntArray(m) { Int.MAX_VALUE }
            val pre = IntArray(m) { -1 }
            val done = BooleanArray(m + 1)
            do {
                done[j0] = true
                val i0 = p[j0]
                var j1 = 0
                var delta = Int.MAX_VALUE
                for (j in 1 until m) {
                    if (!done[j]) {
                        val cur = a[i0 - 1][j - 1] - u[i0] - v[j]
                        if (cur < dist[j]) {
                            dist[j] = cur
                            pre[j] = j0
                        }
                        if (dist[j] < delta) {
                            delta = dist[j]
                            j1 = j
                        }
                    }
                }
                for (j in 0 until m) {
                    if (done[j]) {
                        u[p[j]] += delta
                        v[j] -= delta
                    } else {
                        dist[j] -= delta
                    }
                }
                j0 = j1
            } while (p[j0] != 0)
            while (j0 != 0) {
                val j1 = pre[j0]
                p[j0] = p[j1]
                j0 = j1
            }
        }
        for (j in 1 until m) {
            if (p[j] != 0) {
                ans[p[j] - 1] = j - 1
            }
        }
        return -v[0] to ans
    }
}
