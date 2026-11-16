package simulatebombexplosionsandfallingboxes

// Time:  O(m^2 * n)
// Space: O(m * n)
class Solution {
    fun finalGrid(grid: Array<CharArray>): Array<CharArray> {
        val directions = arrayOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
        val neighbors = arrayOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1)
        val bombs = mutableListOf<Pair<Int, Int>>()
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == '*') bombs.add(r to c)
            }
        }
        for (iteration in grid.indices) {
            var changed = false
            val exploded = mutableListOf<Pair<Int, Int>>()
            for ((r, c) in bombs) {
                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc
                    if (nr >= 0 && nr < grid.size && nc >= 0 && nc < grid[0].size && grid[nr][nc] == '#') {
                        exploded.add(r to c)
                        break
                    }
                }
            }
            for ((r, c) in exploded) {
                for ((dr, dc) in neighbors) {
                    val nr = r + dr
                    val nc = c + dc
                    if (nr >= 0 && nr < grid.size && nc >= 0 && nc < grid[0].size && grid[nr][nc] == '#') {
                        grid[nr][nc] = '-'
                        changed = true
                    }
                }
            }
            for (c in grid[0].indices) {
                for (r in grid.size - 2 downTo 0) {
                    if (grid[r][c] == '#' && grid[r + 1][c] == '-') {
                        val temp = grid[r][c]
                        grid[r][c] = grid[r + 1][c]
                        grid[r + 1][c] = temp
                        changed = true
                    }
                }
            }
            if (!changed) break
        }
        return grid
    }
}
