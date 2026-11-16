package equalsumgridpartitionii

// Time:  O(m * n)
// Space: O(m * n)
class Solution {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        var total = 0L
        for (row in grid) {
            for (x in row) {
                total += x
            }
        }

        fun check(begin1: Int, end1: Int, begin2: Int, end2: Int, get: (Int, Int) -> Int): Boolean {
            var curr = 0L
            val d = if (begin1 < end1) 1 else -1
            val lookup = HashSet<Long>()
            var i = begin1
            while (i != end1) {
                var j = begin2
                while (j != end2) {
                    curr += get(i, j)
                    lookup.add(get(i, j).toLong())
                    ++j
                }
                val diff = curr - (total - curr)
                if (diff == 0L) {
                    return true
                }
                if (i != begin1 && end2 - begin2 != 1) {
                    if (lookup.contains(diff)) {
                        return true
                    }
                } else if (i == begin1) {
                    if (get(begin1, begin2).toLong() == diff || get(begin1, end2 - 1).toLong() == diff) {
                        return true
                    }
                } else {
                    if (get(begin1, 0).toLong() == diff || get(i, 0).toLong() == diff) {
                        return true
                    }
                }
                i += d
            }
            return false
        }

        return check(0, grid.size, 0, grid[0].size) { i, j -> grid[i][j] } ||
            check(grid.size - 1, -1, 0, grid[0].size) { i, j -> grid[i][j] } ||
            check(0, grid[0].size, 0, grid.size) { i, j -> grid[j][i] } ||
            check(grid[0].size - 1, -1, 0, grid.size) { i, j -> grid[j][i] }
    }
}
