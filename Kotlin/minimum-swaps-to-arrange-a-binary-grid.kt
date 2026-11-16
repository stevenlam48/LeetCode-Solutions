package minimumswapstoarrangeabinarygrid

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun minSwaps(grid: Array<IntArray>): Int {
        val n = grid.size
        var result = 0
        for (target in n - 1 downTo 1) {
            var rowIdx = n - 1 - target
            while (rowIdx < n) {
                val row = grid[rowIdx]
                var sum = 0
                for (k in 0 until target) {
                    sum += row[n - 1 - k]
                }
                if (sum == 0) {
                    break
                }
                ++rowIdx
            }
            if (rowIdx == n) {
                return -1
            }
            while (rowIdx != n - 1 - target) {
                val tmp = grid[rowIdx]
                grid[rowIdx] = grid[rowIdx - 1]
                grid[rowIdx - 1] = tmp
                ++result
                --rowIdx
            }
        }
        return result
    }
}
