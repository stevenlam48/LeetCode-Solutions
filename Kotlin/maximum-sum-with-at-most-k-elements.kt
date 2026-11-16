package maximumsumwithatmostkelements
// Time:  O(n * m)
// Space: O(1)

class Solution {
    fun maxSum(grid: Array<IntArray>, limits: IntArray, k: Int): Long {
        val candidates = mutableListOf<Int>()
        for (i in grid.indices) {
            val cnt = minOf(k, limits[i])
            if (cnt - 1 >= 0) {
                grid[i].sort()
                for (j in 0 until cnt) {
                    candidates.add(grid[i][grid[i].size - 1 - j])
                }
            }
        }
        candidates.sortDescending()
        var result = 0L
        if (k - 1 >= 0) {
            for (j in 0 until k) {
                result += candidates[j]
            }
        }
        return result
    }
}
