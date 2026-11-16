package uniquepathsiii

// Time:  O(m * n * 2^(m * n))
// Space: O(m * n * 2^(m * n))

class Solution {
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var todo = 0
        var src = 0 to 0
        var dst = 0 to 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] % 2 == 0) {
                    todo = todo or index(grid, r, c)
                }
                if (grid[r][c] == 1) {
                    src = r to c
                } else if (grid[r][c] == 2) {
                    dst = r to c
                }
            }
        }
        return dp(grid, src, dst, todo, HashMap())
    }

    private fun dp(
        grid: Array<IntArray>,
        src: Pair<Int, Int>,
        dst: Pair<Int, Int>,
        todo: Int,
        lookup: HashMap<Pair<Int, Int>, Int>
    ): Int {
        if (src == dst) {
            return if (todo == 0) 1 else 0
        }
        val key = index(grid, src.first, src.second) to todo
        lookup[key]?.let { return it }
        val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        var result = 0
        for (d in directions) {
            val r = src.first + d.first
            val c = src.second + d.second
            if (r in grid.indices && c in grid[0].indices &&
                grid[r][c] % 2 == 0 && todo and index(grid, r, c) != 0
            ) {
                result += dp(grid, r to c, dst, todo xor index(grid, r, c), lookup)
            }
        }
        lookup[key] = result
        return result
    }

    private fun index(grid: Array<IntArray>, r: Int, c: Int): Int {
        return 1 shl (r * grid[0].size + c)
    }
}
