package numberofdistinctislands

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun numDistinctIslands(grid: Array<IntArray>): Int {
        val islands = mutableSetOf<String>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val island = StringBuilder()
                if (dfs(i, j, grid, island)) {
                    islands.add(island.toString())
                }
            }
        }
        return islands.size
    }

    private fun dfs(i: Int, j: Int, grid: Array<IntArray>, island: StringBuilder): Boolean {
        if (i !in grid.indices || j !in grid[0].indices || grid[i][j] <= 0) {
            return false
        }
        grid[i][j] *= -1
        for ((direction, delta) in DIRECTIONS) {
            island.append(direction)
            dfs(i + delta[0], j + delta[1], grid, island)
        }
        return true
    }

    companion object {
        private val DIRECTIONS = arrayOf(
            Pair('l', intArrayOf(-1, 0)),
            Pair('r', intArrayOf(1, 0)),
            Pair('u', intArrayOf(0, 1)),
            Pair('d', intArrayOf(0, -1))
        )
    }
}
