package minimumcosttomakeatleastonevalidpathinagrid
// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun minCost(grid: Array<IntArray>): Int {
        return aStar(grid, 0 to 0, (grid.size - 1) to (grid[0].size - 1))
    }

    private fun aStar(grid: Array<IntArray>, b: Pair<Int, Int>, t: Pair<Int, Int>): Int {
        val directions = arrayOf(Triple(1, 0, 1), Triple(2, 0, -1), Triple(3, 1, 0), Triple(4, -1, 0))
        var f = 0
        val dh = 1
        var closer = ArrayDeque(listOf(b))
        var detour = ArrayDeque<Pair<Int, Int>>()
        val lookup = HashSet<Int>()
        while (closer.isNotEmpty() || detour.isNotEmpty()) {
            if (closer.isEmpty()) {
                f += dh
                val tmp = closer
                closer = detour
                detour = tmp
            }
            val curr = closer.removeLast()
            if (!lookup.add(curr.first * grid[0].size + curr.second)) {
                continue
            }
            if (curr == t) {
                return f
            }
            for ((nd, dr, dc) in directions) {
                val nb = (curr.first + dr) to (curr.second + dc)
                if (nb.first !in grid.indices || nb.second !in grid[0].indices ||
                    lookup.contains(nb.first * grid[0].size + nb.second)
                ) {
                    continue
                }
                if (nd == grid[curr.first][curr.second]) {
                    closer.addLast(nb)
                } else {
                    detour.addLast(nb)
                }
            }
        }
        return -1
    }
}
