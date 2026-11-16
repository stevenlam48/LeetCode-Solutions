package lastvisitedcellinadirectionalgrid

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun lastVisitedCell(grid: Array<CharArray>): IntArray {
        var r = 0
        var c = 0
        while (true) {
            val (dr, dc) = LOOKUP.getValue(grid[r][c])
            grid[r][c] = '#'
            val nr = r + dr
            val nc = c + dc
            if (!(nr >= 0 && nr < grid.size && nc >= 0 && nc < grid[0].size && grid[nr][nc] != '#')) {
                break
            }
            r = nr
            c = nc
        }
        return intArrayOf(r, c)
    }

    private companion object {
        val LOOKUP = mapOf(
            'L' to (0 to -1),
            'R' to (0 to 1),
            'U' to (-1 to 0),
            'D' to (1 to 0)
        )
    }
}
