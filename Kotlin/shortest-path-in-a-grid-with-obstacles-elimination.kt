package shortestpathinagridwithobstacleselimination

// Time:  O(m * n * k)
// Space: O(m * n)

import kotlin.math.abs

class Solution {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val b = 0 to 0
        val t = (grid.size - 1) to (grid[0].size - 1)
        return aStar(grid, b, t, k)
    }

    private fun aStar(
        grid: Array<IntArray>,
        start: Pair<Int, Int>,
        target: Pair<Int, Int>,
        k: Int
    ): Int {
        var f = g(start, target)
        val dh = 2
        val closer = ArrayDeque<Pair<Pair<Int, Int>, Int>>()
        closer.addLast(start to k)
        val detour = ArrayDeque<Pair<Pair<Int, Int>, Int>>()
        val lookup = HashMap<Int, Int>()
        val m = grid.size
        val n = grid[0].size
        while (closer.isNotEmpty() || detour.isNotEmpty()) {
            if (closer.isEmpty()) {
                f += dh
                closer.addAll(detour)
                detour.clear()
            }
            val (pos, remaining) = closer.removeLast()
            if (pos == target) {
                return f
            }
            val key = pos.first * n + pos.second
            if (lookup.containsKey(key) && lookup[key]!! >= remaining) {
                continue
            }
            lookup[key] = remaining
            for ((dx, dy) in directions) {
                val nb = (pos.first + dx) to (pos.second + dy)
                if (!(0 <= nb.first && nb.first < m &&
                       0 <= nb.second && nb.second < n &&
                       (grid[nb.first][nb.second] == 0 || remaining > 0) &&
                       (!lookup.containsKey(nb.first * n + nb.second) ||
                          lookup[nb.first * n + nb.second]!! < remaining))
                ) {
                    continue
                }
                val nk = remaining - if (grid[nb.first][nb.second] != 0) 1 else 0
                if (dot(dx to dy, (target.first - pos.first) to (target.second - pos.second)) > 0) {
                    closer.addLast(nb to nk)
                } else {
                    detour.addLast(nb to nk)
                }
            }
        }
        return -1
    }

    private fun g(a: Pair<Int, Int>, b: Pair<Int, Int>): Int {
        return abs(a.first - b.first) + abs(a.second - b.second)
    }

    private fun dot(a: Pair<Int, Int>, b: Pair<Int, Int>): Int {
        return a.first * b.first + a.second * b.second
    }

    companion object {
        private val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
    }
}
