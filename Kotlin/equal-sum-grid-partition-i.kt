package equalsumgridpartitioni

// Time:  O(m * n)
// Space: O(1)
class Solution {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        var total = 0L
        for (row in grid) {
            for (x in row) {
                total += x
            }
        }
        if (total % 2L != 0L) {
            return false
        }
        val half = total / 2

        fun check(begin1: Int, end1: Int, begin2: Int, end2: Int, get: (Int, Int) -> Int): Boolean {
            var curr = 0L
            val d = if (begin1 < end1) 1 else -1
            var i = begin1
            while (i != end1) {
                var j = begin2
                while (j != end2) {
                    curr += get(i, j)
                    ++j
                }
                if (curr == half) {
                    return true
                } else if (curr > half) {
                    break
                }
                i += d
            }
            return false
        }

        return check(0, grid.size, 0, grid[0].size) { i, j -> grid[i][j] } ||
            check(0, grid[0].size, 0, grid.size) { i, j -> grid[j][i] }
    }
}
