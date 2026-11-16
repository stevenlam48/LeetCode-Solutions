package escapethespreadingfire

// Time:  O(m * n)
// Space: O(m * n)
class Solution {
    fun maximumMinutes(grid: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(0, -1), intArrayOf(0, 1),
            intArrayOf(-1, 0), intArrayOf(1, 0)
        )
        val GRASS = 0
        val FIRE = 1
        val WALL = 2
        val PERSON = 3
        val INF = 1000000000
        val m = grid.size
        val n = grid[0].size

        val time = HashMap<Int, Array<IntArray>>()
        time[FIRE] = Array(m) { IntArray(n) }
        time[PERSON] = Array(m) { IntArray(n) }

        var q = ArrayList<IntArray>()
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (grid[r][c] == FIRE) {
                    q.add(intArrayOf(r, c, FIRE))
                }
            }
        }
        q.add(intArrayOf(0, 0, PERSON))
        var d = 0
        while (q.isNotEmpty()) {
            val newQ = ArrayList<IntArray>()
            for (cell in q) {
                val r = cell[0]
                val c = cell[1]
                val t = cell[2]
                for (dir in directions) {
                    val nr = r + dir[0]
                    val nc = c + dir[1]
                    if (!(0 <= nr && nr < m && 0 <= nc && nc < n &&
                            grid[nr][nc] != WALL &&
                            ((t == FIRE && grid[nr][nc] != FIRE) ||
                                (t == PERSON && (grid[nr][nc] == GRASS ||
                                    (grid[nr][nc] == FIRE && nr == m - 1 && nc == n - 1 &&
                                        d + 1 == time[FIRE]!![nr][nc])))))
                    ) {
                        continue
                    }
                    if (grid[nr][nc] != FIRE) {
                        grid[nr][nc] = t
                    }
                    if ((nr == m - 1 && nc == n - 1) ||
                        (nr == m - 1 && nc == n - 2) ||
                        (nr == m - 2 && nc == n - 1)
                    ) {
                        time[t]!![nr][nc] = d + 1
                    }
                    newQ.add(intArrayOf(nr, nc, t))
                }
            }
            q = newQ
            ++d
        }

        if (time[PERSON]!![m - 1][n - 1] == 0) {
            return -1
        }
        if (time[FIRE]!![m - 1][n - 1] == 0) {
            return INF
        }
        val diff = time[FIRE]!![m - 1][n - 1] - time[PERSON]!![m - 1][n - 1]
        return if (time[FIRE]!![m - 1][n - 2] - time[PERSON]!![m - 1][n - 2] == diff + 2 ||
            time[FIRE]!![m - 2][n - 1] - time[PERSON]!![m - 2][n - 1] == diff + 2
        ) {
            diff
        } else {
            diff - 1
        }
    }
}
