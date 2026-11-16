package minimumobstacleremovaltoreachcorner

// Time:  O(m * n)
// Space: O(m * n)

// A* Search Algorithm without heap
class Solution {
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val b = intArrayOf(0, 0)
        val t = intArrayOf(grid.size - 1, grid[0].size - 1)
        return aStar(grid, b, t)
    }

    private fun aStar(grid: Array<IntArray>, b: IntArray, t: IntArray): Int {
        val directions = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, -1),
            intArrayOf(1, 0), intArrayOf(-1, 0)
        )
        var f = 0
        val dh = 1
        var closer = ArrayDeque<IntArray>()
        closer.addLast(b)
        var detour = ArrayDeque<IntArray>()
        val lookup = HashSet<Int>()
        while (closer.isNotEmpty() || detour.isNotEmpty()) {
            if (closer.isEmpty()) {
                f += dh
                val tmp = closer
                closer = detour
                detour = tmp
            }
            val cur = closer.removeLast()
            if (!lookup.add(cur[0] * grid[0].size + cur[1])) {
                continue
            }
            if (cur[0] == t[0] && cur[1] == t[1]) {
                return f
            }
            for (d in directions) {
                val nr = cur[0] + d[0]
                val nc = cur[1] + d[1]
                if (!(nr in grid.indices && nc in grid[0].indices &&
                            nr * grid[0].size + nc !in lookup)) {
                    continue
                }
                if (grid[nr][nc] == 0) {
                    closer.addLast(intArrayOf(nr, nc))
                } else {
                    detour.addLast(intArrayOf(nr, nc))
                }
            }
        }
        return -1
    }
}
