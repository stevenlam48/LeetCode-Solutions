package shortestdistancefromallbuildings

// Time:  O(k * m * n), k is the number of the buildings
// Space: O(m * n)

class Solution {
    fun shortestDistance(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var count = 0
        val distances = Array(m) { IntArray(n) }
        val counts = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    ++count
                    bfs(grid, i, j, distances, counts)
                }
            }
        }
        var shortest = Int.MAX_VALUE
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (distances[i][j] < shortest && counts[i][j] == count) {
                    shortest = distances[i][j]
                }
            }
        }
        return if (shortest != Int.MAX_VALUE) shortest else -1
    }

    private fun bfs(
        grid: Array<IntArray>,
        x: Int,
        y: Int,
        distances: Array<IntArray>,
        counts: Array<IntArray>
    ) {
        var distance = 0
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) }
        var previousLevel = mutableListOf(x to y)
        var currentLevel = mutableListOf<Pair<Int, Int>>()
        visited[x][y] = true
        while (previousLevel.isNotEmpty()) {
            ++distance
            currentLevel.clear()
            for (p in previousLevel) {
                for (d in directions) {
                    val i = p.first + d.first
                    val j = p.second + d.second
                    if (i >= 0 && i < m && j >= 0 && j < n &&
                        grid[i][j] == 0 && !visited[i][j]
                    ) {
                        distances[i][j] += distance
                        ++counts[i][j]
                        currentLevel.add(i to j)
                        visited[i][j] = true
                    }
                }
            }
            val temp = previousLevel
            previousLevel = currentLevel
            currentLevel = temp
        }
    }

    private val directions = arrayOf(0 to -1, 0 to 1, -1 to 0, 1 to 0)
}
