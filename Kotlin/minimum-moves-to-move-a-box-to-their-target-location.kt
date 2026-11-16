package minimummovestomoveaboxtotheirtargetlocation

import kotlin.math.abs

// Time:  O(m^2 * n^2)
// Space: O(m^2 * n^2)

class Solution {
    fun minPushBox(grid: Array<CharArray>): Int {
        var b = Pair(0, 0)
        var p = Pair(0, 0)
        var t = Pair(0, 0)
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                when (grid[i][j]) {
                    'B' -> b = Pair(i, j)
                    'S' -> p = Pair(i, j)
                    'T' -> t = Pair(i, j)
                }
            }
        }
        return aStar(grid, b, p, t)
    }

    private fun aStar(grid: Array<CharArray>, b0: Pair<Int, Int>, p0: Pair<Int, Int>, t: Pair<Int, Int>): Int {
        var f = g(b0, t)
        val dh = 2
        var closer = ArrayDeque<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
        var detour = ArrayDeque<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
        closer.addLast(Pair(b0, p0))
        val lookup = HashSet<Long>()
        val m = grid.size
        val n = grid[0].size
        val base = m * n
        while (closer.isNotEmpty() || detour.isNotEmpty()) {
            if (closer.isEmpty()) {
                f += dh
                val tmp = closer
                closer = detour
                detour = tmp
            }
            val state = closer.removeLast()
            val b = state.first
            val p = state.second
            if (b == t) {
                return f
            }
            val key = (b.first * n + b.second).toLong() * base + (p.first * n + p.second)
            if (lookup.contains(key)) {
                continue
            }
            lookup.add(key)
            for (dir in directions) {
                val nb = Pair(b.first + dir[0], b.second + dir[1])
                val np = Pair(b.first - dir[0], b.second - dir[1])
                if (!(0 <= nb.first && nb.first < m &&
                      0 <= nb.second && nb.second < n &&
                      0 <= np.first && np.first < m &&
                      0 <= np.second && np.second < n &&
                      grid[nb.first][nb.second] != '#' && grid[np.first][np.second] != '#' &&
                      !lookup.contains((nb.first * n + nb.second).toLong() * base + (b.first * n + b.second)) &&
                      canReach(grid, b, p, np))) {
                    continue
                }
                if (dot(dir, Pair(t.first - b.first, t.second - b.second)) > 0) {
                    closer.addLast(Pair(nb, b))
                } else {
                    detour.addLast(Pair(nb, b))
                }
            }
        }
        return -1
    }

    private fun g(a: Pair<Int, Int>, b: Pair<Int, Int>): Int {
        return abs(a.first - b.first) + abs(a.second - b.second)
    }

    private fun canReach(grid: Array<CharArray>, b: Pair<Int, Int>, p0: Pair<Int, Int>, t: Pair<Int, Int>): Boolean {
        var closer = ArrayDeque<Pair<Int, Int>>()
        var detour = ArrayDeque<Pair<Int, Int>>()
        closer.addLast(p0)
        val lookup = HashSet<Int>()
        val m = grid.size
        val n = grid[0].size
        lookup.add(b.first * n + b.second)
        while (closer.isNotEmpty() || detour.isNotEmpty()) {
            if (closer.isEmpty()) {
                val tmp = closer
                closer = detour
                detour = tmp
            }
            val p = closer.removeLast()
            if (p == t) {
                return true
            }
            if (lookup.contains(p.first * n + p.second)) {
                continue
            }
            lookup.add(p.first * n + p.second)
            for (dir in directions) {
                val np = Pair(p.first + dir[0], p.second + dir[1])
                if (!(0 <= np.first && np.first < m &&
                      0 <= np.second && np.second < n &&
                      grid[np.first][np.second] != '#' &&
                      !lookup.contains(np.first * n + np.second))) {
                    continue
                }
                if (dot(dir, Pair(t.first - p.first, t.second - p.second)) > 0) {
                    closer.addLast(np)
                } else {
                    detour.addLast(np)
                }
            }
        }
        return false
    }

    private fun dot(a: IntArray, b: Pair<Int, Int>): Int {
        return a[0] * b.first + a[1] * b.second
    }

    companion object {
        private val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
    }
}
