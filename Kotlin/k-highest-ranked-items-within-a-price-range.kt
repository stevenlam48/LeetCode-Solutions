package khighestrankeditemswithinapricerange
// Time:  O(m * n + klogk)
// Space: O(m * n)

class Solution {
    fun highestRankedKItems(
        grid: Array<IntArray>,
        pricing: IntArray,
        start: IntArray,
        k: Int
    ): Array<IntArray> {
        val directions = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        var q = mutableListOf(start[0] to start[1])
        val lookup = Array(grid.size) { IntArray(grid[0].size) { -1 } }
        var d = 0
        lookup[start[0]][start[1]] = d
        val compare = compareBy<IntArray>(
            { lookup[it[0]][it[1]] },
            { grid[it[0]][it[1]] },
            { it[0] },
            { it[1] }
        )
        val result = mutableListOf<IntArray>()
        while (q.isNotEmpty()) {
            if (result.size >= k) {
                if (result.size > k) {
                    result.sortWith(compare)
                    while (result.size > k) {
                        result.removeAt(result.lastIndex)
                    }
                }
                break
            }
            val newQ = mutableListOf<Pair<Int, Int>>()
            for ((r, c) in q) {
                if (pricing[0] <= grid[r][c] && grid[r][c] <= pricing[1]) {
                    result.add(intArrayOf(r, c))
                }
                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc
                    if (!(nr >= 0 && nr < grid.size && nc >= 0 && nc < grid[0].size &&
                            grid[nr][nc] != 0 && lookup[nr][nc] == -1)
                    ) {
                        continue
                    }
                    lookup[nr][nc] = d + 1
                    newQ.add(nr to nc)
                }
            }
            q = newQ
            ++d
        }
        result.sortWith(compare)
        return result.toTypedArray()
    }
}
