package makingalargeisland

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    private val directions = arrayOf(
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(1, 0)
    )

    fun largestIsland(grid: Array<IntArray>): Int {
        var result = 0
        val area = HashMap<Int, Int>()
        var index = 2
        for (r in grid.indices) {
            for (c in grid[r].indices) {
                if (grid[r][c] != 1) {
                    continue
                }
                area[index] = dfs(r, c, index, grid)
                result = maxOf(result, area[index]!!)
                ++index
            }
        }

        for (r in grid.indices) {
            for (c in grid[r].indices) {
                if (grid[r][c] != 0) {
                    continue
                }
                val seen = HashSet<Int>()
                for (d in directions) {
                    val nr = r + d[0]
                    val nc = c + d[1]
                    if (nr in grid.indices && nc in grid[0].indices && grid[nr][nc] > 1) {
                        seen.add(grid[nr][nc])
                    }
                }
                var sum = 0
                for (i in seen) {
                    sum += area[i]!!
                }
                result = maxOf(result, 1 + sum)
            }
        }
        return result
    }

    private fun dfs(r: Int, c: Int, index: Int, grid: Array<IntArray>): Int {
        if (!(r in grid.indices && c in grid[0].indices && grid[r][c] == 1)) {
            return 0
        }
        var result = 1
        grid[r][c] = index
        for (d in directions) {
            result += dfs(r + d[0], c + d[1], index, grid)
        }
        return result
    }
}
