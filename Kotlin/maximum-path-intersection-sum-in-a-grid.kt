package maximumpathintersectionsuminagrid
// Time:  O(n * m)
// Space: O(1)

class Solution {
    fun maxScore(grid: Array<IntArray>): Int {
        fun modifiedKadane(length: Int, get: (Int) -> Int): Int {
            var curr = get(0) + get(1)
            var result = curr
            for (i in 2 until length) {
                curr = maxOf(curr, get(i - 1)) + get(i)
                result = maxOf(result, curr)
            }
            return result
        }

        var result = Int.MIN_VALUE
        for (i in grid.indices) {
            result = maxOf(result, modifiedKadane(grid[0].size) { j -> grid[i][j] })
        }
        for (j in grid[0].indices) {
            result = maxOf(result, modifiedKadane(grid.size) { i -> grid[i][j] })
        }
        for (i in 1 until grid.size - 1) {
            for (j in 1 until grid[0].size - 1) {
                result = maxOf(result, grid[i][j])
            }
        }
        return result
    }
}
