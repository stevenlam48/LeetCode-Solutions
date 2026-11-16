package numberofcornerrectangles

// Time:  O(m^2 * n), m is the number of rows with 1s, n is the number of cols with 1s
// Space: O(m * n)

class Solution {
    fun countCornerRectangles(grid: Array<IntArray>): Int {
        val rows = mutableListOf<List<Int>>()
        for (i in grid.indices) {
            val row = mutableListOf<Int>()
            for (j in grid[i].indices) {
                if (grid[i][j] != 0) {
                    row.add(j)
                }
            }
            if (row.isNotEmpty()) {
                rows.add(row)
            }
        }
        var result = 0
        for (i in rows.indices) {
            val lookup = HashSet<Int>(rows[i])
            for (j in 0 until i) {
                var count = 0
                for (c in rows[j]) {
                    if (lookup.contains(c)) {
                        ++count
                    }
                }
                result += count * (count - 1) / 2
            }
        }
        return result
    }
}
