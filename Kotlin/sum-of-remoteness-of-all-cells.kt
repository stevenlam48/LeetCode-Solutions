package sumofremotenessofallcells

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun sumRemoteness(grid: Array<IntArray>): Long {
        val groups = mutableListOf<Pair<Long, Int>>()
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == -1) {
                    continue
                }
                groups.add(bfs(grid, i, j))
            }
        }
        var total = 0L
        for (group in groups) {
            total += group.first
        }
        var result = 0L
        for (group in groups) {
            result += (total - group.first) * group.second
        }
        return result
    }

    private fun bfs(grid: Array<IntArray>, startI: Int, startJ: Int): Pair<Long, Int> {
        val directions = arrayOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
        var total = grid[startI][startJ].toLong()
        var count = 1
        grid[startI][startJ] = -1
        var queue = mutableListOf(startI to startJ)
        while (queue.isNotEmpty()) {
            val newQueue = mutableListOf<Pair<Int, Int>>()
            for (cell in queue) {
                for (direction in directions) {
                    val ni = cell.first + direction.first
                    val nj = cell.second + direction.second
                    if (ni !in grid.indices || nj !in grid[0].indices || grid[ni][nj] == -1) {
                        continue
                    }
                    total += grid[ni][nj]
                    ++count
                    grid[ni][nj] = -1
                    newQueue.add(ni to nj)
                }
            }
            queue = newQueue
        }
        return total to count
    }
}
