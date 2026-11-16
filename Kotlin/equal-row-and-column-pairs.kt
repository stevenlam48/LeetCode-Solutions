package equalrowandcolumnpairs
// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val cnt1 = HashMap<List<Int>, Int>()
        for (row in grid) {
            val key = row.toList()
            cnt1[key] = (cnt1[key] ?: 0) + 1
        }
        val cnt2 = HashMap<List<Int>, Int>()
        for (j in grid[0].indices) {
            val col = MutableList(grid.size) { 0 }
            for (i in grid.indices) {
                col[i] = grid[i][j]
            }
            cnt2[col] = (cnt2[col] ?: 0) + 1
        }
        var result = 0
        for ((key, count) in cnt1) {
            val columnCount = cnt2[key] ?: continue
            result += count * columnCount
        }
        return result
    }
}
