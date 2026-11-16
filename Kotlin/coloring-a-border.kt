package coloringaborder

// Time:  O(m * n)
// Space: O(m + n)


class Solution {
    fun colorBorder(grid: Array<IntArray>, r0: Int, c0: Int, color: Int): Array<IntArray> {
        val directions = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(1, 0))
        val borders = ArrayList<IntArray>()
        val lookup = HashSet<Long>()
        fun key(r: Int, c: Int): Long = r.toLong() * grid[0].size + c
        lookup.add(key(r0, c0))
        val q = ArrayDeque<IntArray>()
        q.add(intArrayOf(r0, c0))
        while (q.isNotEmpty()) {
            val cell = q.removeFirst()
            val r = cell[0]
            val c = cell[1]
            var isBorder = false
            for (dir in directions) {
                val nr = r + dir[0]
                val nc = c + dir[1]
                if (!(nr in grid.indices && nc in grid[0].indices && grid[nr][nc] == grid[r][c])) {
                    isBorder = true
                    continue
                }
                if (!lookup.add(key(nr, nc))) {
                    continue
                }
                q.add(intArrayOf(nr, nc))
            }
            if (isBorder) {
                borders.add(intArrayOf(r, c))
            }
        }
        for (border in borders) {
            grid[border[0]][border[1]] = color
        }
        return grid
    }
}
