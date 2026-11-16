package checkifthereisavalidpathinagrid

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun hasValidPath(grid: Array<IntArray>): Boolean {
        val directions = arrayOf(
            arrayOf(intArrayOf(0, 1), intArrayOf(0, -1)),
            arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0)),
            arrayOf(intArrayOf(0, -1), intArrayOf(1, 0)),
            arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)),
            arrayOf(intArrayOf(0, -1), intArrayOf(-1, 0)),
            arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1))
        )
        val m = grid.size
        val n = grid[0].size

        for (dir in directions[grid[0][0] - 1]) {
            var r = dir[0]
            var c = dir[1]
            if (!(0 <= r && r < m && 0 <= c && c < n)) {
                continue
            }
            var pr = 0
            var pc = 0
            while (r != m - 1 || c != n - 1) {
                var isFound = false
                for (d in directions[grid[r][c] - 1]) {
                    val dx = d[0]
                    val dy = d[1]
                    val nr = r + dx
                    val nc = c + dy
                    if ((nr == pr && nc == pc) ||
                        !(0 <= nr && nr < m && 0 <= nc && nc < n)
                    ) {
                        continue
                    }
                    val dirs = directions[grid[nr][nc] - 1]
                    if (dirs.none { it[0] == -dx && it[1] == -dy }) {
                        continue
                    }
                    pr = r
                    pc = c
                    r = nr
                    c = nc
                    isFound = true
                    break
                }
                if (!isFound) {
                    return false
                }
            }
            return true
        }
        return m == 1 && n == 1
    }
}
