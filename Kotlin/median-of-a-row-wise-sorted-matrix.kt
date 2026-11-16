package medianofarowwisesortedmatrix
// Time:  O(logr * mlogn), r = O(right-left+1) = O(10^6), O(logr) = O(20)
// Space: O(1)

class Solution {
    fun matrixMedian(grid: Array<IntArray>): Int {
        fun upperBound(row: IntArray, x: Int): Int {
            var left = 0
            var right = row.size
            while (left < right) {
                val mid = left + (right - left) / 2
                if (row[mid] <= x) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            return left
        }

        fun check(x: Int): Boolean {
            var total = 0
            for (row in grid) {
                total += upperBound(row, x)
            }
            return total > grid.size * grid[0].size / 2
        }

        var left = grid.minOf { it[0] }
        var right = grid.maxOf { it[it.size - 1] }
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
