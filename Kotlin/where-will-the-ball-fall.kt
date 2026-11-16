package wherewilltheballfall

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun findBall(grid: Array<IntArray>): IntArray {
        val result = IntArray(grid[0].size)
        for (i in grid[0].indices) {
            var c = i
            for (r in grid.indices) {
                val nc = c + grid[r][c]
                if (!(0 <= nc && nc < grid[0].size && grid[r][nc] == grid[r][c])) {
                    c = -1
                    break
                }
                c = nc
            }
            result[i] = c
        }
        return result
    }
}
